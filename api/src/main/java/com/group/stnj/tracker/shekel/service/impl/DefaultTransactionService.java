package com.group.stnj.tracker.shekel.service.impl;

import com.group.stnj.tracker.shekel.repository.TransactionRepository;
import com.group.stnj.tracker.shekel.service.TransactionService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class DefaultTransactionService implements TransactionService {
  private final TransactionRepository transactionRepository;

  @Override
  public String create() {
    return transactionRepository.save();
  }
}
