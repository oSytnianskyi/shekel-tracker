terraform {
  required_providers {
    auth0 = {
      source  = "auth0/auth0"
      version = "~> 0.34.0"
    }
  }
}

provider "auth0" {
  domain        = var.auth0_domain
  client_id     = var.auth0_client_id
  client_secret = var.auth0_client_secret
}

resource "auth0_client" "mobile" {
  name      = var.project_name
  callbacks = local.mobile_callbacks
  app_type  = "native"

  allowed_logout_urls = local.mobile_allowed_logout_urls
  allowed_origins     = local.mobile_allowed_origins
  web_origins         = local.mobile_web_origins

  oidc_conformant            = true
  token_endpoint_auth_method = "none"

  mobile {
    android {
      app_package_name         = var.mobile_app_package_name
      sha256_cert_fingerprints = var.mobile_sha256_cert_fingerprints
    }

    ios {
      app_bundle_identifier = var.mobile_app_bundle_identifier
      team_id               = var.mobile_team_id
    }
  }

  jwt_configuration {
    alg = "RS256"
  }
}

locals {
  mobile_allowed_logout_urls = [
    "shekelTracker://auth",
    "org.reactjs.native.example.shekelTracker://shekelTracker-staging.us.auth0.com/ios/org.reactjs.native.example.shekelTracker/callback",
    "https://shekelTracker-staging.us.auth0.com/v2/logouthttps://shekelTracker-staging.us.auth0.com/v2/logout",
    "http:/localhost:8080",
    "com.shekelTracker://shekelTracker-staging.us.auth0.com/ios/com.shekelTracker/callback",
    "com.shekelTracker://shekelTracker-staging.us.auth0.com/android/com.shekelTracker/callback"
  ]
  mobile_allowed_origins = ["https://shekelTracker-staging.us.auth0.com/v2/logout"]
  mobile_callbacks       = [
    "shekelTracker://auth",
    "org.reactjs.native.example.shekelTracker://shekelTracker-staging.us.auth0.com/ios/org.reactjs.native.example.shekelTracker/callback",
    "http:/localhost:8080",
    "com.shekelTracker://shekelTracker-staging.us.auth0.com/ios/com.shekelTracker/callback",
    "com.shekelTracker://shekelTracker-staging.us.auth0.com/android/com.shekelTracker/callback"
  ]
  mobile_web_origins = [
    "shekelTracker://auth",
    "org.reactjs.native.example.shekelTracker://shekelTracker-staging.us.auth0.com/ios/org.reactjs.native.example.shekelTracker/callback",
    "https://shekelTracker-staging.us.auth0.com/v2/logout",
    "http:/localhost:8080"
  ]
}
