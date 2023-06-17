package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.User;

public interface UserRepository {
  User findUserById(String uuid);
}
