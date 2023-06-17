package com.bookkeeping.service;

import com.bookkeeping.entity.User;

public interface InternalUserService {
  void createUserIfNotExist(String email);

  User getCurrentUser();

  String getCurrentUserEmail();

  Long getCurrentUserId();
}
