package com.bookkeeping.service.impl;

import com.bookkeeping.entity.Account;
import com.bookkeeping.exception.BookkeepingResourceNotFoundException;
import com.bookkeeping.repository.AccountRepository;
import com.bookkeeping.service.InternalAccountService;
import com.bookkeeping.service.InternalUserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class InternalAccountServiceImpl implements InternalAccountService {
  private final InternalUserService internalUserService;
  private final AccountRepository accountRepository;

  @Override
  public Account getAccount(Long accountId) {
    String email = internalUserService.getCurrentUserEmail();
    return accountRepository.findByIdAndUserEmail(accountId, email)
      .orElseThrow(() -> new BookkeepingResourceNotFoundException(String.format("Account by id: %s, not found", accountId)));
  }
}
