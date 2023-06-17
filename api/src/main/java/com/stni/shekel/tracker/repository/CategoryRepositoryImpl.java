package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.Category;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository {
  @Override
  public List<Category> findAllByUserId(Long id) {
    return null;
  }

  @Override
  public Optional<Category> findByIdAndUserId(Long id, Long userId) {
    return Optional.empty();
  }

  @Override
  public List<Category> findAllByAccountIdAndUserId(Long accountId, Long userId) {
    return null;
  }
}
