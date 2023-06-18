package com.stni.shekel.tracker.service;

import com.stni.shekel.tracker.dto.CreateUserDto;
import com.stni.shekel.tracker.dto.CurrentUserDto;

public interface UserService {
  CurrentUserDto getCurrentUser();

  String createUser(CreateUserDto dto);
}
