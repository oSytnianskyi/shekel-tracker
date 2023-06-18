package com.stni.shekel.tracker.dto;

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
public class Auth0IdentitiesDto {

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("provider")
  private String provider;
}
