package com.bookkeeping.repository;

import com.bookkeeping.entity.Account;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepositoryImpl implements AccountRepository {
  @Override
  public List<Account> findAllByUserId(Long id) {
    return null;
  }

  @Override
  public Optional<Account> findByIdAndUserId(Long id, Long userId) {
    return Optional.empty();
  }
}
