package com.stni.shekel.tracker.service.local.impl;

import com.stni.shekel.tracker.entity.User;
import com.stni.shekel.tracker.exception.ShekelTrackerValidationException;
import com.stni.shekel.tracker.repository.UserRepository;
import com.stni.shekel.tracker.service.local.LocalUserService;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class LocalUserServiceImpl implements LocalUserService {
  private static final String EMAIL_JWT_CLAIM_NAME = "https://shekel-tracker.com/uuid";

  private final UserRepository userRepository;
  private final JsonWebToken jwt;

  @Override
  public User getCurrentUser() {
    String uuid = getCurrentUserUuid();
    return userRepository.findUserById(uuid);
  }

  public String getCurrentUserUuid() {
    if (Objects.isNull(jwt)) {
      throw new ShekelTrackerValidationException("Token is null, can not proceed request");
    }
    return jwt.getClaim(EMAIL_JWT_CLAIM_NAME);
  }
}
