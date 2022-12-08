terraform {
  backend "s3" {
    bucket = "hb-terraform-state-configuration"
    key    = "staging.tfstate"
    region = "us-west-2"
  }
}

locals {
  project_name_full = "homeBookkeeping"
  app               = "hb"
  environment       = "staging"
  region            = "us-west-2"
  default_tags = {
    project     = "home_bookkeeping"
    environment = local.environment
  }
}

provider "aws" {
  profile = "default"
  region  = local.region
}

module "auth0" {
  source = "../../modules/auth0"

  auth0_domain                    = data.aws_ssm_parameter.auth0_domain.value
  auth0_client_id                 = data.aws_ssm_parameter.auth0_client_id.value
  auth0_client_secret             = data.aws_ssm_parameter.auth0_client_secret.value
  project_name                    = local.project_name_full
  mobile_app_bundle_identifier    = data.aws_ssm_parameter.app_bundle_identifier.value
  mobile_app_package_name         = data.aws_ssm_parameter.app_package_name.value
  mobile_sha256_cert_fingerprints = [data.aws_ssm_parameter.sha256_cert_fingerprints.value]
  mobile_team_id                  = data.aws_ssm_parameter.team_id.value
}

module "lambda" {
  source = "../../modules/aws/lambda"

  auth0_client_id = data.aws_ssm_parameter.auth0_client_id.value
  environment     = local.environment
  jdbc_login      = data.aws_ssm_parameter.jdbc_login.value
  jdbc_password   = data.aws_ssm_parameter.jdbc_password.value
  jdbc_url        = data.aws_ssm_parameter.jdbc_url.value
  project_name    = local.default_tags.project
  role_arn        = module.iam.api_lambda_role_arn

  depends_on = [module.iam]
}

module "iam" {
  source = "../../modules/aws/iam"

  api_lambda_role_name = "${local.default_tags.project}-api-lambda-role-${local.environment}"
}

module "api_gateway" {
  source = "../../modules/aws/api_gateway"

  api_lambda_function_invoke_arn = module.lambda.api_lambda_function_invoke_arn
  environment                    = local.environment
  project_name                   = local.default_tags.project
}

module "cloudwatch" {
  source = "../../modules/aws/cloudwatch"

  api_function_name = module.lambda.api_function_name

  depends_on = [module.lambda]
}
