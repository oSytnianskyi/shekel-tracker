package com.stni.shekel.tracker.model;

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
public class CreateUserModel {
  private String uuid;
  private String email;
  private String password;
  private String lastName;
  private String firstName;
}
