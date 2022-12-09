package com.bookkeeping.service;

import com.bookkeeping.entity.Account;

public interface InternalAccountService {
  Account getAccount(Long accountId);
}
