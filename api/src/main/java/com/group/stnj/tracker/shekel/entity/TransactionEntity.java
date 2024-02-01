package com.group.stnj.tracker.shekel.entity;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Getter
@Setter
@Builder
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class TransactionEntity {

  @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDbAttribute(value = "PK")})
  private String pk;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "SK")})
  private String sk;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "description")})
  private String description;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "amount")})
  private BigDecimal amount;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "user_id")})
  private String userId;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "category_name")})
  private String categoryName;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "category_id")})
  private String categoryId;
}
