package com.group.stnj.tracker.shekel.service;

import com.group.stnj.tracker.shekel.model.CategoryModel;
import com.group.stnj.tracker.shekel.model.CategoryNameModel;

public interface CategoryService {
  CategoryModel getCategoryByName(CategoryNameModel nameModel);
}
