package com.bookkeeping.service.impl;

import com.bookkeeping.dto.CurrentUserDto;
import com.bookkeeping.entity.User;
import com.bookkeeping.service.InternalUserService;
import com.bookkeeping.service.UserService;
import com.bookkeeping.util.MapperUtil;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final InternalUserService internalUserService;

  @Override
  public CurrentUserDto getCurrentUser() {
    User user = internalUserService.getCurrentUser();
    return MapperUtil.USER_MAPPER.toDto(user);
  }
}
