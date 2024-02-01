package com.group.stnj.tracker.shekel.service.impl;

import com.group.stnj.tracker.shekel.entity.TransactionEntity;
import com.group.stnj.tracker.shekel.mapper.TransactionMapper;
import com.group.stnj.tracker.shekel.model.CreateTransactionModel;
import com.group.stnj.tracker.shekel.repository.TransactionRepository;
import com.group.stnj.tracker.shekel.service.TransactionService;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class DefaultTransactionService implements TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;

  @Override
  public String create(CreateTransactionModel model) {
    TransactionEntity transactionEntity = transactionMapper.toTransactionEntity(model);
    TransactionEntity transactionUserEntity = transactionMapper.toTransactionUserEntity(transactionEntity);
    TransactionEntity transactionCategoryEntity = transactionMapper.toTransactionCategoryEntity(transactionEntity, model);
    List<TransactionEntity> entities = List.of(transactionEntity, transactionUserEntity, transactionCategoryEntity);
    return transactionRepository.saveAll(entities);
  }
}
