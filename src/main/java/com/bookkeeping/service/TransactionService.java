package com.bookkeeping.service;

import com.bookkeeping.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
  List<TransactionDto> getTransactions(Long categoryId);
}
