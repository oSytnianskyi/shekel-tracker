package com.bookkeeping;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
  info = @Info(
    title = "Bookkeeping API",
    version = "1.0"
  ),
  security = @SecurityRequirement(name = "bearerAuth"),
  components = @Components(
    securitySchemes = @SecurityScheme(
      securitySchemeName = "bearerAuth",
      scheme = "bearer",
      bearerFormat = "JWT",
      type = SecuritySchemeType.HTTP,
      in = SecuritySchemeIn.HEADER
    )
  )
)
public class BookkeepingApplication extends Application {
}
