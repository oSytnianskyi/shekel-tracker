package com.group.stnj.tracker.shekel.config.dynamodb;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MetaData {
  public static final String TABLE_NAME = "shekel";

  public static final String USER_PK = "User#";
  public static final String CATEGORY_PK = "Category#";

  // Transaction
  public static final String TRANSACTION_PK = "Transaction#";
  public static final String TRANSACTION_DETAILS_SK = "Details#";
}
