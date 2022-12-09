package com.bookkeeping.service;

import com.bookkeeping.dto.CreateTransactionDto;
import com.bookkeeping.dto.CreatedEntityIdDto;
import com.bookkeeping.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
  List<TransactionDto> getTransactions(Long categoryId);

  CreatedEntityIdDto createTransaction(Long accountId, Long categoryId, CreateTransactionDto transactionDto);
}
