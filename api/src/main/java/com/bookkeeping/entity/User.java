package com.bookkeeping.entity;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RegisterForReflection
@RequiredArgsConstructor
public class User {
  private Long id;
  private String email;
  private String lastName;
  private String firstName;
  List<Category> categories = new ArrayList<>();
  List<Transaction> transactions = new ArrayList<>();
  List<Account> accounts = new ArrayList<>();
}
