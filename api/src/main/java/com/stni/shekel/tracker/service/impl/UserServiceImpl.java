package com.stni.shekel.tracker.service.impl;

import com.stni.shekel.tracker.dto.CurrentUserDto;
import com.stni.shekel.tracker.entity.User;
import com.stni.shekel.tracker.local.service.LocalUserService;
import com.stni.shekel.tracker.mapper.UserMapper;
import com.stni.shekel.tracker.service.ThirdPartyUserManagementService;
import com.stni.shekel.tracker.service.UserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final ThirdPartyUserManagementService userManagementService;
  private final LocalUserService localUserService;
  private final UserMapper userMapper;

  @Override
  public CurrentUserDto getCurrentUser() {
    User user = localUserService.getCurrentUser();
    return userMapper.toDto(user);
  }

  @Override
  public String verifyUser() {
    //TODO: verify in DB
    String email = localUserService.getCurrentUserEmail();
    userManagementService.verifyUser(email);
    return null;
  }
}
