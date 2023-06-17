package com.bookkeeping.service.impl;

import com.bookkeeping.entity.User;
import com.bookkeeping.exception.ApplicationValidationException;
import com.bookkeeping.repository.UserRepository;
import com.bookkeeping.service.InternalUserService;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class InternalUserServiceImpl implements InternalUserService {
  private static final String EMAIL_JWT_CLAIM_NAME = "https://homeBookkeeping.com/email";

  private final UserRepository userRepository;
  private final JsonWebToken jwt;

  @Override
  public String getCurrentUserEmail() {
    if (Objects.isNull(jwt)) {
      throw new ApplicationValidationException("Token is null, can not proceed request");
    }
    String email = jwt.getClaim(EMAIL_JWT_CLAIM_NAME);
    createUserIfNotExist(email);
    return email;
  }

  @Override
  public Long getCurrentUserId() {
    User user = getCurrentUser();
    return user.getId();
  }

  @Override
  public void createUserIfNotExist(String email) {
    boolean exist = userRepository.existsByEmail(email);

    if (!exist) {
      User user = createUser(email);
    }
  }

  @Override
  public User getCurrentUser() {
    String email = getCurrentUserEmail();
    return userRepository.findByEmail(email);
  }

  private User createUser(String email) {
    User user = new User();
    user.setEmail(email);
    return user;
  }
}
