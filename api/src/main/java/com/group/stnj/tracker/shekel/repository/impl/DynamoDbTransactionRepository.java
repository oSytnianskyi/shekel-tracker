package com.group.stnj.tracker.shekel.repository.impl;

import com.group.stnj.tracker.shekel.entity.TransactionEntity;
import com.group.stnj.tracker.shekel.repository.TransactionRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.model.TransactWriteItemsEnhancedRequest;

@ApplicationScoped
@RequiredArgsConstructor
public class DynamoDbTransactionRepository implements TransactionRepository {
  private final DynamoDbEnhancedClient enhancedClient;

  @Inject
  @Named("transactionTable")
  DynamoDbTable<TransactionEntity> transactionTable;

  @Override
  public String saveAll(List<TransactionEntity> entities) {
    TransactWriteItemsEnhancedRequest.Builder transactWriteBuilder = TransactWriteItemsEnhancedRequest.builder();
    for (TransactionEntity entity : entities) {
      transactWriteBuilder.addPutItem(transactionTable, entity);
    }
    TransactWriteItemsEnhancedRequest transactBatchWriteRequest = transactWriteBuilder.build();
    enhancedClient.transactWriteItems(transactBatchWriteRequest);
    return "Mock save to DynamoDB";
  }
}
