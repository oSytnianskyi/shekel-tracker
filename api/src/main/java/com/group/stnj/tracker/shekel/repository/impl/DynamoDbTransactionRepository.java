package com.group.stnj.tracker.shekel.repository.impl;

import com.group.stnj.tracker.shekel.repository.TransactionRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DynamoDbTransactionRepository implements TransactionRepository {

  @Override
  public String save() {
    return "Mock save to DynamoDB";
  }
}
