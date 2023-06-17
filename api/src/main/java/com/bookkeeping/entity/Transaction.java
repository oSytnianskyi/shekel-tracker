package com.bookkeeping.entity;

import com.bookkeeping.meta.TransactionType;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Getter
@Setter
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Transaction {

  @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDbAttribute(value = "PK")})
  private String pk;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "SK")})
  private String sk;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "description")})
  private String description;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "type")})
  private TransactionType type;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "account")})
  private String account;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "amount")})
  private BigDecimal amount;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "category")})
  private Category category;
}
