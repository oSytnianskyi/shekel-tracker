package com.bookkeeping.util;

import com.bookkeeping.mapper.UserMapper;

import org.mapstruct.factory.Mappers;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MapperUtil {

  // User
  public static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
}
