package com.bookkeeping.service.impl;

import com.bookkeeping.exception.ApplicationValidationException;
import com.bookkeeping.service.CurrentUserService;
import com.bookkeeping.service.InternalUserService;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {
  private static final String EMAIL_JWT_CLAIM_NAME = "https://homeBookkeeping.com/email";

  private final InternalUserService internalUserService;
  private final JsonWebToken jwt;

  @Override
  public String getCurrentUserEmail() {
    if (Objects.isNull(jwt)) {
      throw new ApplicationValidationException("Token is null, can not proceed request");
    }
    String email = jwt.getClaim(EMAIL_JWT_CLAIM_NAME);
    internalUserService.createUserIfNotExist(email);
    return email;
  }
}
