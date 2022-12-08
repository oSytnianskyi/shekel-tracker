package com.bookkeeping.mapper;

import com.bookkeeping.dto.CreateTransactionDto;
import com.bookkeeping.dto.TransactionDto;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.Transaction;
import com.bookkeeping.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

  @Mapping(target = "id", source = "transaction.id")
  @Mapping(target = "categoryId", source = "category.id")
  @Mapping(target = "categoryName", source = "category.name")
  @Mapping(target = "description", source = "transaction.description")
  TransactionDto toDto(Transaction transaction, Category category);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", source = "user")
  @Mapping(target = "category", source = "category")
  @Mapping(target = "description", source = "transactionDto.description")
  Transaction toEntity(CreateTransactionDto transactionDto, Category category, User user);
}
