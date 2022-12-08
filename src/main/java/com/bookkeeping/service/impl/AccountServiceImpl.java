package com.bookkeeping.service.impl;

import com.bookkeeping.dto.AccountDto;
import com.bookkeeping.entity.Account;
import com.bookkeeping.repository.AccountRepository;
import com.bookkeeping.service.AccountService;
import com.bookkeeping.service.InternalUserService;
import com.bookkeeping.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final InternalUserService internalUserService;
  private final AccountRepository accountRepository;

  @Override
  public List<AccountDto> getAccounts() {
    Long userId = internalUserService.getCurrentUserId();
    List<Account> accounts = accountRepository.findAllByUserId(userId);
    return accounts.stream()
      .map(MapperUtil.ACCOUNT_MAPPER::toDto)
      .collect(Collectors.toList());
  }
}