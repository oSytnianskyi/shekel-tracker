package com.bookkeeping.service.impl;

import com.bookkeeping.dto.CreateTransactionDto;
import com.bookkeeping.dto.CreatedEntityIdDto;
import com.bookkeeping.dto.TransactionDto;
import com.bookkeeping.entity.Account;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.Transaction;
import com.bookkeeping.entity.User;
import com.bookkeeping.repository.TransactionRepository;
import com.bookkeeping.service.InternalAccountService;
import com.bookkeeping.service.InternalCategoryService;
import com.bookkeeping.service.InternalUserService;
import com.bookkeeping.service.TransactionService;
import com.bookkeeping.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final InternalCategoryService internalCategoryService;
  private final InternalAccountService internalAccountService;
  private final TransactionRepository transactionRepository;
  private final InternalUserService internalUserService;

  @Override
  public List<TransactionDto> getTransactions(Long categoryId) {
    Category category = internalCategoryService.getCategory(categoryId);
    List<Transaction> transactions = transactionRepository.findAllByCategoryId(categoryId);

    return transactions.stream()
      .map(transaction -> MapperUtil.TRANSACTION_MAPPER.toDto(transaction, category))
      .collect(Collectors.toList());
  }

  @Override
  public CreatedEntityIdDto createTransaction(Long accountId, Long categoryId, CreateTransactionDto transactionDto) {
    User user = internalUserService.getCurrentUser();
    Account account = internalAccountService.getAccount(accountId);
    Category category = internalCategoryService.getCategory(categoryId);

    Transaction transaction = MapperUtil.TRANSACTION_MAPPER.toEntity(transactionDto, category, user, account);
    Transaction createdTransaction = null;

    Long transactionId = createdTransaction.getId();
    return new CreatedEntityIdDto(transactionId);
  }
}
