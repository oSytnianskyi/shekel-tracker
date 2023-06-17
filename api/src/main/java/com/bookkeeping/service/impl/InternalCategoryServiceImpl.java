package com.bookkeeping.service.impl;

import com.bookkeeping.entity.Category;
import com.bookkeeping.exception.BookkeepingResourceNotFoundException;
import com.bookkeeping.repository.CategoryRepository;
import com.bookkeeping.service.InternalCategoryService;
import com.bookkeeping.service.InternalUserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class InternalCategoryServiceImpl implements InternalCategoryService {
  private final InternalUserService internalUserService;
  private final CategoryRepository categoryRepository;

  @Override
  public Category getCategory(Long categoryId) {
    Long userId = internalUserService.getCurrentUserId();
    return categoryRepository.findByIdAndUserId(categoryId, userId)
      .orElseThrow(() -> new BookkeepingResourceNotFoundException(String.format("Category by id: %s, not found", categoryId)));
  }
}
