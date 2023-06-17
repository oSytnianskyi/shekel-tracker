package com.bookkeeping.entity;

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
public class Category {
  private Long id;
  private User user;
  private String name;
  private String description;
  private Set<Account> accounts = new HashSet<>();
  private List<Transaction> transactions = new ArrayList<>();
}
