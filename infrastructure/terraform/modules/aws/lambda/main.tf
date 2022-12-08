data "archive_file" "dummy_source_code" {
  type        = "zip"
  output_path = "/tmp/dummy_source_code.zip"
  source {
    content  = <<EOF
module.exports.handler = async (event, context, callback) => {
	const response = `Please redeploy your lambda code!`;
	callback(null, response);
};
EOF
    filename = "index.js"
  }
}

resource "aws_lambda_function" "api" {
  function_name                  = "${var.project_name}-api-${var.environment}"
  role                           = var.role_arn
  handler                        = "not.used.in.provided.runtime"
  memory_size                    = "2048"
  package_type                   = "Zip"
  runtime                        = "provided"
  filename                       = data.archive_file.dummy_source_code.output_path
  timeout                        = "300"
  publish                        = true
  reserved_concurrent_executions = 50

  environment {
    variables = {
      DISABLE_SIGNAL_HANDLERS = "true"
      AUTH0_CLIENT_ID         = var.auth0_client_id
      JDBC_URL                = var.jdbc_url
      JDBC_LOGIN              = var.jdbc_login
      JDBC_PASSWORD           = var.jdbc_password
    }
  }

  tracing_config {
    mode = "Active"
  }
}

resource "aws_lambda_alias" "main" {
  name             = "live"
  function_name    = aws_lambda_function.api.arn
  function_version = "$LATEST"

  lifecycle {
    ignore_changes = [function_version]
  }
}

resource "aws_lambda_permission" "main" {
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.api.function_name
  principal     = "apigateway.amazonaws.com"
}
