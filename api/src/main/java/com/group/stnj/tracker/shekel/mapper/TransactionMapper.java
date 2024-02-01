package com.group.stnj.tracker.shekel.mapper;

import com.group.stnj.tracker.shekel.config.dynamodb.MetaData;
import com.group.stnj.tracker.shekel.dto.CreateTransactionDto;
import com.group.stnj.tracker.shekel.entity.TransactionEntity;
import com.group.stnj.tracker.shekel.model.CategoryModel;
import com.group.stnj.tracker.shekel.model.CategoryNameModel;
import com.group.stnj.tracker.shekel.model.CreateTransactionModel;
import com.group.stnj.tracker.shekel.model.UserModel;
import com.group.stnj.tracker.shekel.service.CategoryService;
import com.group.stnj.tracker.shekel.service.UserService;

import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.UUID;

import javax.inject.Inject;

@Mapper(uses = CategoryMapper.class)
public abstract class TransactionMapper {

  @Inject
  UserService userService;

  @Inject
  CategoryService categoryService;

  public abstract CreateTransactionModel createTransactionModelToDto(CreateTransactionDto dto);

  public TransactionEntity toTransactionEntity(CreateTransactionModel model) {
    UUID uuid = UUID.randomUUID();
    String pk = String.format("%s%s", MetaData.TRANSACTION_PK, uuid);
    String sk = String.format("%s%s", MetaData.TRANSACTION_DETAILS_SK, uuid);

    BigDecimal amount = model.getAmount();
    String description = model.getDescription();
    return TransactionEntity.builder()
      .pk(pk)
      .sk(sk)
      .amount(amount)
      .description(description)
      .build();
  }

  public TransactionEntity toTransactionUserEntity(TransactionEntity transactionEntity) {
    UserModel user = userService.getCurrentUser();

    String sk = user.getSk();
    String id = user.getUuid();
    String pk = transactionEntity.getPk();
    return TransactionEntity.builder()
      .pk(pk)
      .sk(sk)
      .userId(id)
      .build();
  }

  public TransactionEntity toTransactionCategoryEntity(TransactionEntity transactionEntity, CreateTransactionModel transactionModel) {
    CategoryNameModel categoryName = transactionModel.getCategory();
    CategoryModel category = categoryService.getCategoryByName(categoryName);

    String id = category.getId();
    String sk = category.getSk();
    String pk = transactionEntity.getPk();
    return TransactionEntity.builder()
      .pk(pk)
      .sk(sk)
      .categoryId(id)
      .build();
  }
}
