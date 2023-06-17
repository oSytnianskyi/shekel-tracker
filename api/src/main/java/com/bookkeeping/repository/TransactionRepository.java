package com.bookkeeping.repository;

import com.bookkeeping.entity.Transaction;

import java.util.List;

public interface TransactionRepository {
  List<Transaction> findAllByCategoryId(Long categoryId);
}
