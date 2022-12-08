package com.bookkeeping.service.impl;

import com.bookkeeping.entity.User;
import com.bookkeeping.repository.UserRepository;
import com.bookkeeping.service.InternalUserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class InternalUserServiceImpl implements InternalUserService {
  private final UserRepository userRepository;

  @Override
  public void createUserIfNotExist(String email) {
    boolean exist = userRepository.existsByEmail(email);

    if (!exist) {
      User user = createUser(email);
      userRepository.saveAndFlush(user);
    }
  }

  private User createUser(String email) {
    User user = new User();
    user.setEmail(email);
    return user;
  }
}
