package com.stni.shekel.tracker.service.local.impl;

import com.stni.shekel.tracker.entity.User;
import com.stni.shekel.tracker.repository.UserRepository;
import com.stni.shekel.tracker.service.local.LocalJwtService;
import com.stni.shekel.tracker.service.local.LocalUserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class LocalUserServiceImpl implements LocalUserService {
  private final LocalJwtService localJwtService;
  private final UserRepository userRepository;

  @Override
  public User getCurrentUser() {
    String uuid = localJwtService.getCurrentUserUuid();
    return userRepository.findUserById(uuid);
  }
}
