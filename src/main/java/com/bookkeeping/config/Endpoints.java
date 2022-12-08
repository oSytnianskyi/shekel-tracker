package com.bookkeeping.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoints {
  public static final String API = "/api";
  public static final String VERSION1 = "/v1";
  public static final String API_PREFIX_V1 = API + VERSION1;

  // Database
  public static final String DATABASE = API_PREFIX_V1 + "/database";
}