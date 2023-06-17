package com.bookkeeping.repository;

import com.bookkeeping.entity.User;

public interface UserRepository {
  boolean existsByEmail(String email);

  User findByEmail(String email);
}
