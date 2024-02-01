package com.group.stnj.tracker.shekel.manager.impl;

import com.group.stnj.tracker.shekel.dto.CreateTransactionDto;
import com.group.stnj.tracker.shekel.manager.TransactionManager;
import com.group.stnj.tracker.shekel.mapper.TransactionMapper;
import com.group.stnj.tracker.shekel.model.CreateTransactionModel;
import com.group.stnj.tracker.shekel.service.TransactionService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionManagerImpl implements TransactionManager {
  private final TransactionService transactionService;
  private final TransactionMapper transactionMapper;

  @Override
  public String create(CreateTransactionDto dto) {
    CreateTransactionModel model = transactionMapper.createTransactionModelToDto(dto);
    return transactionService.create(model);
  }
}
