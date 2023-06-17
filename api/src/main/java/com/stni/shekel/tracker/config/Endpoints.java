package com.stni.shekel.tracker.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoints {
  private static final String API = "/api";
  private static final String VERSION1 = "/v1";
  private static final String API_PREFIX_V1 = API + VERSION1;

  public static final String TEST = "/test";
  public static final String USERS = API_PREFIX_V1 + "/users";
}
