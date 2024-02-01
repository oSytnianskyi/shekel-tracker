package com.group.stnj.tracker.shekel.service;

import com.group.stnj.tracker.shekel.model.CreateTransactionModel;

public interface TransactionService {
  String create(CreateTransactionModel model);
}
