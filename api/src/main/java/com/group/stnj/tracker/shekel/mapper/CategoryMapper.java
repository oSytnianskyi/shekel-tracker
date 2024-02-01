package com.group.stnj.tracker.shekel.mapper;

import com.group.stnj.tracker.shekel.dto.CategoryNameDto;
import com.group.stnj.tracker.shekel.model.CategoryNameModel;

import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
  CategoryNameModel categoryNameDtoToModel(CategoryNameDto dto);
}
