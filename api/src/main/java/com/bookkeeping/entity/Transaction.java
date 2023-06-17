package com.bookkeeping.entity;

import com.bookkeeping.meta.TransactionType;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
@RequiredArgsConstructor
public class Transaction {
  private Long id;
  private User user;
  private Account account;
  private BigDecimal amount;
  private Category category;
  private String description;
  private TransactionType type;
}
