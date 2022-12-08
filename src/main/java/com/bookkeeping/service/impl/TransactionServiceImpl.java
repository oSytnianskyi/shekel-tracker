package com.bookkeeping.service.impl;

import com.bookkeeping.dto.TransactionDto;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.Transaction;
import com.bookkeeping.exception.BookkeepingResourceNotFoundException;
import com.bookkeeping.repository.CategoryRepository;
import com.bookkeeping.repository.TransactionRepository;
import com.bookkeeping.service.TransactionService;
import com.bookkeeping.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final TransactionRepository transactionRepository;
  private final CategoryRepository categoryRepository;

  @Override
  public List<TransactionDto> getTransactions(Long categoryId) {
    Category category = getCategory(categoryId);
    List<Transaction> transactions = transactionRepository.findAllByCategoryId(categoryId);

    return transactions.stream()
      .map(transaction -> MapperUtil.TRANSACTION_MAPPER.toDto(transaction, category))
      .collect(Collectors.toList());
  }

  private Category getCategory(Long categoryId) {
    return categoryRepository.findById(categoryId)
      .orElseThrow(() -> new BookkeepingResourceNotFoundException(String.format("Category by id: %s, not found", categoryId)));
  }
}
