package com.stni.shekel.tracker.local.service.impl;

import com.stni.shekel.tracker.entity.User;
import com.stni.shekel.tracker.local.service.LocalJwtService;
import com.stni.shekel.tracker.local.service.LocalUserService;
import com.stni.shekel.tracker.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class LocalUserServiceImpl implements LocalUserService {
  private final LocalJwtService localJwtService;
  private final UserRepository userRepository;

  @Override
  public User getCurrentUser() {
    String email = localJwtService.getCurrentUserEmail();
    return userRepository.findUserById(email);
  }

  @Override
  public String getCurrentUserEmail() {
    return localJwtService.getCurrentUserEmail();
  }
}
