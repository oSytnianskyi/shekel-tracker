package com.bookkeeping.dto;

import javax.validation.constraints.NotBlank;

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
public class CreateCategoryDto {
  private String description;

  @NotBlank
  private String name;
}
