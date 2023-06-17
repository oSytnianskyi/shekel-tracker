package com.bookkeeping.repository;

import com.bookkeeping.entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {
  @Override
  public boolean existsByEmail(String email) {
    return false;
  }

  @Override
  public User findByEmail(String email) {
    return null;
  }
}
