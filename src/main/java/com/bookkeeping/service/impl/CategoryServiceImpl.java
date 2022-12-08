package com.bookkeeping.service.impl;

import com.bookkeeping.repository.CategoryRepository;
import com.bookkeeping.service.CategoryService;
import com.bookkeeping.service.InternalUserService;
import com.bookkeeping.util.MapperUtil;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final InternalUserService internalUserService;
  private final CategoryRepository categoryRepository;

  @Override
  public List<String> getCategoriesNames() {
    Long userId = internalUserService.getCurrentUserId();
    return categoryRepository.findAllNamesByUserId(userId);
  }
}
