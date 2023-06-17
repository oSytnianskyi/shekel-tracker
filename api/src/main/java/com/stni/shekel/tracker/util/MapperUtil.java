package com.stni.shekel.tracker.util;

import com.stni.shekel.tracker.mapper.AccountMapper;
import com.stni.shekel.tracker.mapper.CategoryMapper;
import com.stni.shekel.tracker.mapper.TransactionMapper;
import com.stni.shekel.tracker.mapper.UserMapper;

import org.mapstruct.factory.Mappers;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MapperUtil {

  // User
  public static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

  // Category
  public static final CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

  // Transaction
  public static final TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);

  // Account
  public static final AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);
}
