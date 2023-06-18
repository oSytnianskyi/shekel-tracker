package com.stni.shekel.tracker.dto;

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
public class Auth0UserModel {
  private String email;
  private String userId;
  private String creationType;
}
