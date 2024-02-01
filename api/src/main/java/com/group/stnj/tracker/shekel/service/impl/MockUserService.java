package com.group.stnj.tracker.shekel.service.impl;

import com.group.stnj.tracker.shekel.model.UserModel;
import com.group.stnj.tracker.shekel.service.UserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class MockUserService implements UserService {

  @Override
  public UserModel getCurrentUser() {
    return new UserModel("user_pk", "user_sk", "user_uuid","test@mail.com");
  }
}
