package com.bookkeeping.entity;

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
public class User {

  @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDbAttribute(value = "PK")})
  private String pk;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "SK")})
  private String sk;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "email")})
  private String email;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "last_name")})
  private String lastName;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "first_name")})
  private String firstName;
}
