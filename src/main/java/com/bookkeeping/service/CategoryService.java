package com.bookkeeping.service;

import com.bookkeeping.dto.CreateCategoryDto;
import com.bookkeeping.dto.CreatedEntityIdDto;

import java.util.List;

public interface CategoryService {
  List<String> getCategoriesNames();

  CreatedEntityIdDto createCategory(CreateCategoryDto createCategoryDto);
}
