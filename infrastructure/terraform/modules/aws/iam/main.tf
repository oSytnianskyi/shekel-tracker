resource "aws_iam_role" "api-lambda" {
  name               = var.api_lambda_role_name
  assume_role_policy = <<EOF
{
 "Version": "2012-10-17",
 "Statement": [
   {
     "Action": "sts:AssumeRole",
     "Principal": {
       "Service": "lambda.amazonaws.com"
     },
     "Effect": "Allow",
     "Sid": ""
   }
 ]
}
EOF
}

resource "aws_iam_role_policy_attachment" "LambdaPolicyAttachment" {
  role       = aws_iam_role.api-lambda.name
  count      = length(local.api_lambda_iam_policy_arn)
  policy_arn = local.api_lambda_iam_policy_arn[count.index]
}

locals {
  api_lambda_iam_policy_arn = [
    "arn:aws:iam::aws:policy/AWSLambdaExecute",
    "arn:aws:iam::aws:policy/service-role/AWSLambdaVPCAccessExecutionRole"
  ]
}
