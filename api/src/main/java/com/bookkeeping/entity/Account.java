package com.bookkeeping.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
@RequiredArgsConstructor
public class Account {
  private Long id;
  private User user;
  private String name;
  private String description;
  private BigDecimal balance;
  private Set<Category> categories = new HashSet<>();
  private List<Transaction> transactions = new ArrayList<>();
}
