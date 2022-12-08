terraform {
  backend "s3" {
    bucket = "hb-terraform-state-configuration"
    key    = "staging-hbs.tfstate"
    region = "us-west-2"
  }
}

provider "aws" {
  profile = "default"
  region  = local.region
}

locals {
  project_name_full = "homeBookkeeping"
  app               = "hb"
  environment       = "staging"
  region            = "us-west-2"
  default_tags      = {
    project     = "home_bookkeeping"
    environment = local.environment
  }
  vpc_id = "vpc-fcabe898"
}

resource "aws_db_instance" "database" {
  apply_immediately                   = true
  auto_minor_version_upgrade          = true
  copy_tags_to_snapshot               = true
  iam_database_authentication_enabled = true
  performance_insights_enabled        = true
  port                                = "5432"
  identifier                          = "${local.app}-${local.environment}"
  engine                              = "postgres"
  engine_version                      = "13.7"
  instance_class                      = "db.t3.micro"
  db_name                             = "${local.app}_${local.environment}"
  username                            = data.aws_ssm_parameter.jdbc_login.value
  password                            = data.aws_ssm_parameter.jdbc_password.value
  enabled_cloudwatch_logs_exports     = ["postgresql"]
  multi_az                            = false
  publicly_accessible                 = true
  allocated_storage                   = 20
  storage_type                        = "gp2"
  parameter_group_name                = aws_db_parameter_group.main.name
  backup_retention_period             = 7
  skip_final_snapshot                 = true
  vpc_security_group_ids              = [aws_security_group.postgres_sg.id]
  delete_automated_backups            = false
  deletion_protection                 = true
  db_subnet_group_name                = aws_db_subnet_group.main.name
}

resource "aws_security_group" "postgres_sg" {
  description = "Allow access to postgresql"
  name        = "${local.default_tags.project}-${local.environment}"
  vpc_id      = local.vpc_id

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_ssm_parameter" "db_url" {
  name  = "/${local.app}/${local.environment}/db/jdbc_url"
  type  = "SecureString"
  value = "jdbc:p6spy:postgresql://${aws_db_instance.database.address}:${aws_db_instance.database.port}/${aws_db_instance.database.db_name}"
}

resource "aws_db_subnet_group" "main" {
  name       = "${local.app}_${local.environment}"
  subnet_ids = data.aws_subnets.main.ids
}

data "aws_subnets" "main" {
  filter {
    name   = "vpc-id"
    values = [local.vpc_id]
  }
}

resource "aws_db_parameter_group" "main" {
  name   = "${local.app}-${local.environment}-pg"
  family = "postgres13"

  parameter {
    name  = "log_checkpoints"
    value = "0"
  }

  parameter {
    name  = "log_min_duration_statement"
    value = "2000"
  }

  parameter {
    name  = "log_statement"
    value = "ddl"
  }
}
