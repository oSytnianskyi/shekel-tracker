package com.bookkeeping.service;

import com.bookkeeping.dto.AccountDto;
import com.bookkeeping.dto.CreateAccountDto;
import com.bookkeeping.dto.CreatedEntityIdDto;

import java.util.List;

public interface AccountService {
  List<AccountDto> getAccounts();

  CreatedEntityIdDto createAccount(CreateAccountDto accountDto);

  AccountDto getAccount(Long accountId);
}
