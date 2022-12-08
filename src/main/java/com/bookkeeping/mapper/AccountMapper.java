package com.bookkeeping.mapper;

import com.bookkeeping.dto.AccountDto;
import com.bookkeeping.dto.CreateAccountDto;
import com.bookkeeping.entity.Account;
import com.bookkeeping.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {
  AccountDto toDto(Account account);

  @Mapping(target = "id", ignore = true)
  Account toEntity(CreateAccountDto accountDto, User user);
}
