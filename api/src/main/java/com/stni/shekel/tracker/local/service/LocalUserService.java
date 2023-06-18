package com.stni.shekel.tracker.local.service;

import com.stni.shekel.tracker.entity.User;

public interface LocalUserService {
  User getCurrentUser();

  String getCurrentUserEmail();
}
