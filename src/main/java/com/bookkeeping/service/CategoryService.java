package com.bookkeeping.service;

import com.bookkeeping.dto.CategoryPreviewDto;
import com.bookkeeping.dto.CreateCategoryDto;
import com.bookkeeping.dto.CreatedEntityIdDto;

import java.util.List;

public interface CategoryService {
  List<CategoryPreviewDto> getCategoriesPreview();

  CreatedEntityIdDto createCategory(CreateCategoryDto createCategoryDto);
}
