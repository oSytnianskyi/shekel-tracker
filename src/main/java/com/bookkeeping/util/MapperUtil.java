package com.bookkeeping.util;

import com.bookkeeping.mapper.CategoryMapper;
import com.bookkeeping.mapper.TransactionMapper;
import com.bookkeeping.mapper.UserMapper;

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
}
