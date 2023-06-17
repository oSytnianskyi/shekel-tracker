package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
  List<Account> findAllByUserId(Long id);

  Optional<Account> findByIdAndUserId(Long id, Long userId);
}
