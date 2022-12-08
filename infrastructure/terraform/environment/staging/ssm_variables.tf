data "aws_ssm_parameter" "auth0_domain" {
  name = "/${local.app}/${local.environment}/auth0/domain"
}

data "aws_ssm_parameter" "auth0_client_id" {
  name = "/${local.app}/${local.environment}/auth0/machine/client_id"
}

data "aws_ssm_parameter" "auth0_client_secret" {
  name = "/${local.app}/${local.environment}/auth0/machine/secret"
}

data "aws_ssm_parameter" "app_package_name" {
  name = "/${local.app}/${local.environment}/auth0/native/app_package_name"
}

data "aws_ssm_parameter" "sha256_cert_fingerprints" {
  name = "/${local.app}/${local.environment}/auth0/native/sha256_cert_fingerprints"
}

data "aws_ssm_parameter" "app_bundle_identifier" {
  name = "/${local.app}/${local.environment}/auth0/native/app_bundle_identifier"
}

data "aws_ssm_parameter" "team_id" {
  name = "/${local.app}/${local.environment}/auth0/native/team_id"
}

data "aws_ssm_parameter" "jdbc_password" {
  name = "/${local.app}/${local.environment}/db/jdbc_password"
}

data "aws_ssm_parameter" "jdbc_url" {
  name = "/${local.app}/${local.environment}/db/jdbc_url"
}

data "aws_ssm_parameter" "jdbc_login" {
  name = "/${local.app}/${local.environment}/db/jdbc_login"
}
