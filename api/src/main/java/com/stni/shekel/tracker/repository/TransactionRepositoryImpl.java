package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.Transaction;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionRepositoryImpl implements TransactionRepository {
  @Override
  public List<Transaction> findAllByCategoryId(Long categoryId) {
    return null;
  }
}
