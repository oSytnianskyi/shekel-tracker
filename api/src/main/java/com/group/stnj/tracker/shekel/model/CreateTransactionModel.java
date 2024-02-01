package com.group.stnj.tracker.shekel.model;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class CreateTransactionModel {
  private BigDecimal amount;
  private String description;
  private CategoryNameModel category;
}
