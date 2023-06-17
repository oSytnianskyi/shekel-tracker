package com.bookkeeping.repository;

import com.bookkeeping.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findAllByCategoryId(Long categoryId);
}
