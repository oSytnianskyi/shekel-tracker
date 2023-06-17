package com.stni.shekel.tracker.service.local.impl;

import com.stni.shekel.tracker.exception.ShekelTrackerAuthenticationException;
import com.stni.shekel.tracker.service.local.LocalJwtService;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class LocalJwtServiceImpl implements LocalJwtService {
  private static final String UUID_JWT_CLAIM_NAME = "https://shekel-tracker.com/uuid";

  private final JsonWebToken jwt;

  @Override
  public String getCurrentUserUuid() {
    boolean tokenIsNull = Objects.isNull(jwt);
    if (tokenIsNull) {
      throw new ShekelTrackerAuthenticationException("Token is missed, Authentication not passed");
    }
    String uuid = jwt.getClaim(UUID_JWT_CLAIM_NAME);
    if (StringUtils.isBlank(uuid)) {
      throw new ShekelTrackerAuthenticationException("Uuid is missed, Authentication not passed");
    }
    return uuid;
  }
}
