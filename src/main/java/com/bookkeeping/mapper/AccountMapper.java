package com.bookkeeping.mapper;

import com.bookkeeping.dto.AccountDto;
import com.bookkeeping.entity.Account;

import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
  AccountDto toDto(Account account);
}
