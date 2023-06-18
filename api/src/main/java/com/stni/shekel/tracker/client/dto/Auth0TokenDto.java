package com.stni.shekel.tracker.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Auth0TokenDto {

  @JsonProperty("access_token")
  private String accessToken;

  @JsonProperty("scope")
  private String scope;

  @JsonProperty("expires_in")
  private String expiresIn;

  @JsonProperty("token_type")
  private String tokenType;
}
