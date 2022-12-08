data "aws_ssm_parameter" "jdbc_password" {
  name = "/${local.app}/${local.environment}/db/jdbc_password"
}

data "aws_ssm_parameter" "jdbc_login" {
  name = "/${local.app}/${local.environment}/db/jdbc_login"
}
