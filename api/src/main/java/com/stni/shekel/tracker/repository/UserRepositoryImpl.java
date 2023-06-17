package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.config.dynamodb.DynamoDbTableMetaData;
import com.stni.shekel.tracker.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;

@ApplicationScoped
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  @Inject
  @Named("userTable")
  DynamoDbTable<User> userTable;

  @Override
  public User findUserById(String uuid) {
    GetItemEnhancedRequest getItemRequest = getUserByIdRequest(uuid);
    return userTable.getItem(getItemRequest);
  }

  private GetItemEnhancedRequest getUserByIdRequest(String uuid) {
    String pk = String.format("%s%S", DynamoDbTableMetaData.USER_PK, uuid);
    return GetItemEnhancedRequest.builder()
      .key(key -> key.partitionValue(pk).sortValue(DynamoDbTableMetaData.USER_DETAIL))
      .build();
  }
}
