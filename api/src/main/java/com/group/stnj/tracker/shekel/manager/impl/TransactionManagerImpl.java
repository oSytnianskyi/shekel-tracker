package com.group.stnj.tracker.shekel.manager.impl;

import com.group.stnj.tracker.shekel.manager.TransactionManager;
import com.group.stnj.tracker.shekel.service.TransactionService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionManagerImpl implements TransactionManager {
  private final TransactionService transactionService;

  @Override
  public String create() {
    return transactionService.create();
  }
}
