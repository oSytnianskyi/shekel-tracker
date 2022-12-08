resource "aws_api_gateway_rest_api" "main" {
  name = "${var.project_name}-api-${var.environment}"
  endpoint_configuration {
    types = ["REGIONAL"]
  }
}

resource "aws_api_gateway_resource" "main" {
  parent_id   = aws_api_gateway_rest_api.main.root_resource_id
  path_part   = "{proxy+}"
  rest_api_id = aws_api_gateway_rest_api.main.id
}

resource "aws_api_gateway_method" "main" {
  authorization = "NONE"
  http_method   = "ANY"
  resource_id   = aws_api_gateway_resource.main.id
  rest_api_id   = aws_api_gateway_rest_api.main.id
}

resource "aws_api_gateway_deployment" "main" {
  rest_api_id = aws_api_gateway_rest_api.main.id

  triggers = {
    redeployment = sha1(jsonencode([
      aws_api_gateway_resource.main.id,
      aws_api_gateway_method.main.id,
      aws_api_gateway_integration.main.id,
    ]))
  }

  lifecycle {
    create_before_destroy = true
  }

  depends_on = [aws_api_gateway_method.main, aws_api_gateway_integration.main]
}

resource "aws_api_gateway_stage" "main" {
  deployment_id = aws_api_gateway_deployment.main.id
  rest_api_id   = aws_api_gateway_rest_api.main.id
  stage_name    = var.environment
}

resource "aws_api_gateway_integration" "main" {
  http_method             = aws_api_gateway_method.main.http_method
  resource_id             = aws_api_gateway_resource.main.id
  rest_api_id             = aws_api_gateway_rest_api.main.id
  type                    = "AWS_PROXY"
  integration_http_method = "POST"
  uri                     = var.api_lambda_function_invoke_arn
  timeout_milliseconds    = "29000"
}

resource "aws_api_gateway_method_settings" "main" {
  rest_api_id = aws_api_gateway_rest_api.main.id
  stage_name  = aws_api_gateway_stage.main.stage_name
  method_path = "*/*"

  settings {
    throttling_burst_limit = 3000
    throttling_rate_limit  = 1000
  }
}
