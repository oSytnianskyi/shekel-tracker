package com.group.stnj.tracker.shekel.config.rest;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoint {
  private static final String API = "/api";
  private static final String VERSION1 = "/v1";
  private static final String API_PREFIX_V1 = API + VERSION1;

  public static final String TRANSACTIONS = API_PREFIX_V1 + "/transactions";
}
