package com.stni.shekel.tracker.client.param;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@StaticInitSafe
@ConfigMapping(prefix = "auth0.credentials.m2m")
public interface Auth0CredentialsParams {

  @WithName("client-id")
  String clientId();

  @WithName("audience")
  String audience();

  @WithName("grand-type")
  String grandType();

  @WithName("client-secret")
  String clientSecret();
}
