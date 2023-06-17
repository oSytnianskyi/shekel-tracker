package com.bookkeeping.dto;

import com.bookkeeping.meta.TransactionType;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

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
public class CreateTransactionDto {
  private String description;

  @NotNull
  private BigDecimal amount;

  @NotNull
  private TransactionType type;
}
