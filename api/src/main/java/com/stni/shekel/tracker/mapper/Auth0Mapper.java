package com.stni.shekel.tracker.mapper;

import com.stni.shekel.tracker.dto.Auth0IdentitiesDto;
import com.stni.shekel.tracker.dto.Auth0UserDto;
import com.stni.shekel.tracker.dto.Auth0UserModel;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface Auth0Mapper {

  @Mapping(target = "userId", ignore = true)
  @Mapping(target = "creationType", ignore = true)
  Auth0UserModel toModel(Auth0UserDto dto);

  List<Auth0UserModel> toModels(List<Auth0UserDto> dtos);

  @AfterMapping
  default Auth0UserModel userModelAfterMapping(@MappingTarget Auth0UserModel model, Auth0UserDto dto) {
    Auth0IdentitiesDto identities = dto.getIdentities().get(0);

    String userId = identities.getUserId();
    model.setUserId(userId);

    String provider = identities.getProvider();
    model.setCreationType(provider);
    return model;
  }
}
