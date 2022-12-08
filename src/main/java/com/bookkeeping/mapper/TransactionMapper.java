package com.bookkeeping.mapper;

import com.bookkeeping.dto.TransactionDto;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.Transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

  @Mapping(target = "id", source = "transaction.id")
  @Mapping(target = "categoryId", source = "category.id")
  @Mapping(target = "categoryName", source = "category.name")
  @Mapping(target = "description", source = "transaction.description")
  TransactionDto toDto(Transaction transaction, Category category);
}
