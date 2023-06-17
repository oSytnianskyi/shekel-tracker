package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@ApplicationScoped
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  @Inject
  @Named("userTable")
  DynamoDbTable<User> userTable;

  @Override
  public void test() {
    Key partitionKey = Key.builder().partitionValue(AttributeValue.builder().s("USER#1").build()).build();
    User item = userTable.getItem(getItemByPkAndSk("USER#1", ""));
    System.out.println(item);
  }

  public static GetItemEnhancedRequest getItemByPkAndSk(String pk, String sk) {
    Key key = Key.builder()
      .partitionValue(pk)
      .sortValue(sk)
      .build();

    return GetItemEnhancedRequest.builder()
      .key(key)
      .build();
  }
}
