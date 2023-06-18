package com.stni.shekel.tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

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
public class Auth0UserDto {

  @JsonProperty("email")
  private String email;

  @JsonProperty("identities")
  List<Auth0IdentitiesDto> identities = new ArrayList<>();
}
