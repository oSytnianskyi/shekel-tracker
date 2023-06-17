package com.stni.shekel.tracker.config.dynamodb;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DynamoDbTableMetaData {
  public static final String TABLE_NAME = "shekel";

  public static final String USER_PK = "USER#";
  public static final String USER_DETAIL = "DETAIL";
}
