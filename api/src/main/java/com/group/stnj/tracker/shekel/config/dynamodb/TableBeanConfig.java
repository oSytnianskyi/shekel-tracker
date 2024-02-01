package com.group.stnj.tracker.shekel.config.dynamodb;

import com.group.stnj.tracker.shekel.entity.CategoryEntity;
import com.group.stnj.tracker.shekel.entity.TransactionEntity;
import com.group.stnj.tracker.shekel.entity.UserEntity;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Dependent
@RequiredArgsConstructor
public class TableBeanConfig {
  private final DynamoDbEnhancedClient enhancedClient;

  @Produces
  @Named("userTable")
  public DynamoDbTable<UserEntity> userTable() {
    return enhancedClient.table(
      MetaData.TABLE_NAME,
      TableSchema.fromClass(UserEntity.class)
    );
  }

  @Produces
  @Named("transactionTable")
  public DynamoDbTable<TransactionEntity> transactionTable() {
    return enhancedClient.table(
      MetaData.TABLE_NAME,
      TableSchema.fromClass(TransactionEntity.class)
    );
  }

  @Produces
  @Named("categoryTable")
  public DynamoDbTable<CategoryEntity> categoryTable() {
    return enhancedClient.table(
      MetaData.TABLE_NAME,
      TableSchema.fromClass(CategoryEntity.class)
    );
  }
}
