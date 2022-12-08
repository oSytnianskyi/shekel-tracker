package com.bookkeeping.mapper;

import com.bookkeeping.dto.CreateCategoryDto;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "transactions", ignore = true)
  Category toEntity(CreateCategoryDto categoryDto, User user);
}
