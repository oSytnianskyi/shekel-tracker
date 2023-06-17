package com.bookkeeping.dto;

import java.math.BigDecimal;

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
public class TransactionDto {
  private Long id;
  private String type;
  private Long categoryId;
  private BigDecimal amount;
  private String description;
  private String categoryName;
}
