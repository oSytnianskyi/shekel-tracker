package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.Transaction;

import java.util.List;

public interface TransactionRepository {
  List<Transaction> findAllByCategoryId(Long categoryId);
}
