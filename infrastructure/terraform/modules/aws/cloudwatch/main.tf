resource "aws_cloudwatch_log_group" "api" {
  name              = "/aws/lambda/${var.api_function_name}"
  retention_in_days = 30
}
