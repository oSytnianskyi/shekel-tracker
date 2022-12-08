package com.bookkeeping.service;

import com.bookkeeping.dto.CurrentUserDto;

public interface CurrentUserService {
  String getCurrentUserEmail();

  CurrentUserDto getCurrentUser();

  Long getCurrentUserId();
}
