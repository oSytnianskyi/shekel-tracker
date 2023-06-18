package com.stni.shekel.tracker.service.impl;

import com.stni.shekel.tracker.client.Auth0Client;
import com.stni.shekel.tracker.dto.Auth0UserDto;
import com.stni.shekel.tracker.dto.Auth0UserLinkDto;
import com.stni.shekel.tracker.dto.Auth0UserModel;
import com.stni.shekel.tracker.mapper.Auth0Mapper;
import com.stni.shekel.tracker.service.ThirdPartyUserManagementService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Comparator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class Auth0UserManagementServiceImpl implements ThirdPartyUserManagementService {
  private final Auth0Mapper auth0Mapper;

  @Inject
  @RestClient
  Auth0Client auth0Client;

  @Override
  public void verifyUser(String email) {
    String luceneFormatEmail = String.format("email:%s", email);
    List<Auth0UserDto> users = auth0Client.getUsersByEmail(luceneFormatEmail);

    int identicalEmailUsersCount = users.size();
    if (identicalEmailUsersCount > 1) {
      linkUsers(users);
    }
  }

  private void linkUsers(List<Auth0UserDto> users) {
    List<Auth0UserModel> models = auth0Mapper.toModels(users);
    models.sort(Comparator.comparing(Auth0UserModel::getCreationType));
    Auth0UserModel auth0ProviderModel = models.get(0);
    Auth0UserModel oauthProviderModel = models.get(1);


    String userId = auth0ProviderModel.getUserId();
    String creationType = auth0ProviderModel.getCreationType();
    Auth0UserLinkDto auth0UserLinkDto = new Auth0UserLinkDto(creationType, userId);

    String googleOauthCreationType = oauthProviderModel.getCreationType();
    String primaryUserId = oauthProviderModel.getUserId();
    String qwe = String.format("%s|%s", googleOauthCreationType, primaryUserId);
    auth0Client.linUsers(qwe, auth0UserLinkDto);
  }
}
