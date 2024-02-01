package com.group.stnj.tracker.shekel.manager;

import com.group.stnj.tracker.shekel.dto.CreateTransactionDto;

public interface TransactionManager {
  String create(CreateTransactionDto dto);
}
