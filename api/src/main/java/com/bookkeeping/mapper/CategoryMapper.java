package com.bookkeeping.mapper;

import com.bookkeeping.dto.CategoryPreviewDto;
import com.bookkeeping.dto.CreateCategoryDto;
import com.bookkeeping.entity.Account;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.User;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CategoryMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "accounts", ignore = true)
  @Mapping(target = "transactions", ignore = true)
  @Mapping(target = "user", source = "user")
  Category toEntity(CreateCategoryDto categoryDto, User user);

  CategoryPreviewDto toPreviewDto(Category category);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "accounts", ignore = true)
  @Mapping(target = "transactions", ignore = true)
  @Mapping(target = "name", source = "categoryDto.name")
  @Mapping(target = "description", source = "categoryDto.description")
  Category toEntity(CreateCategoryDto categoryDto, User user, Account account);

  @AfterMapping
  default void categoryMapping(@MappingTarget Category category, Account account) {
    category.addAccount(account);
  }
}
