package com.stni.shekel.tracker.mapper;

import com.stni.shekel.tracker.dto.CurrentUserDto;
import com.stni.shekel.tracker.entity.User;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
  CurrentUserDto toDto(User user);
}
