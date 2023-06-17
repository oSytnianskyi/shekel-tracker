package com.bookkeeping.repository;

import com.bookkeeping.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
  List<Account> findAllByUserId(Long id);

  Optional<Account> findByIdAndUserId(Long id, Long userId);
}
