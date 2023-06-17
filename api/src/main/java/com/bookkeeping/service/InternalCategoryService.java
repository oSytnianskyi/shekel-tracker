package com.bookkeeping.service;

import com.bookkeeping.entity.Category;

public interface InternalCategoryService {
  Category getCategory(Long categoryId);
}
