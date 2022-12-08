package com.bookkeeping.service;

import com.bookkeeping.dto.AccountDto;

import java.util.List;

public interface AccountService {
  List<AccountDto> getAccounts();
}
