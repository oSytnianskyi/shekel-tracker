package com.bookkeeping.config.dynamodb;

import com.bookkeeping.entity.User;

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
  public DynamoDbTable<User> hubstaffMappingTable() {
    return enhancedClient.table(DynamoDbTableMetaData.TABLE_NAME, TableSchema.fromClass(User.class));
  }
}
