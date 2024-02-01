package com.group.stnj.tracker.shekel.service.impl;

import com.group.stnj.tracker.shekel.model.CategoryModel;
import com.group.stnj.tracker.shekel.model.CategoryNameModel;
import com.group.stnj.tracker.shekel.service.CategoryService;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.runtime.annotations.RegisterForReflection;

@ApplicationScoped
@RegisterForReflection
public class MockCategoryService implements CategoryService {

  @Override
  public CategoryModel getCategoryByName(CategoryNameModel nameModel) {
    return new CategoryModel("category_pk", "category_sk","category_id" ,"category_name", "category_description");
  }
}
