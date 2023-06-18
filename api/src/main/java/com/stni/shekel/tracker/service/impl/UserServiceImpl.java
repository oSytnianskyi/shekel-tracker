package com.stni.shekel.tracker.service.impl;

import com.stni.shekel.tracker.dto.CreateUserDto;
import com.stni.shekel.tracker.dto.CurrentUserDto;
import com.stni.shekel.tracker.entity.User;
import com.stni.shekel.tracker.mapper.UserMapper;
import com.stni.shekel.tracker.service.UserService;
import com.stni.shekel.tracker.service.local.LocalUserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final LocalUserService localUserService;
  private final UserMapper userMapper;

  @Override
  public CurrentUserDto getCurrentUser() {
    User user = localUserService.getCurrentUser();
    return userMapper.toDto(user);
  }

  @Override
  public String createUser(CreateUserDto dto) {
    return null;
  }
}
