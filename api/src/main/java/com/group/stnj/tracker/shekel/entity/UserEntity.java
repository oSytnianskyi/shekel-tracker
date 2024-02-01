package com.group.stnj.tracker.shekel.entity;


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
public class UserEntity {

  @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDbAttribute(value = "PK")})
  private String pk;

  @Getter(onMethod_ = {@DynamoDbSortKey, @DynamoDbAttribute(value = "SK")})
  private String sk;

  @Getter(onMethod_ = {@DynamoDbAttribute(value = "email")})
  private String email;
}
