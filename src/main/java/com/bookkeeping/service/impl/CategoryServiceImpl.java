package com.bookkeeping.service.impl;

import com.bookkeeping.dto.CategoryPreviewDto;
import com.bookkeeping.dto.CreateCategoryDto;
import com.bookkeeping.dto.CreatedEntityIdDto;
import com.bookkeeping.entity.Account;
import com.bookkeeping.entity.Category;
import com.bookkeeping.entity.User;
import com.bookkeeping.repository.CategoryRepository;
import com.bookkeeping.service.CategoryService;
import com.bookkeeping.service.InternalAccountService;
import com.bookkeeping.service.InternalUserService;
import com.bookkeeping.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final InternalAccountService internalAccountService;
  private final InternalUserService internalUserService;
  private final CategoryRepository categoryRepository;

  @Override
  public List<CategoryPreviewDto> getCategoriesPreview() {
    Long userId = internalUserService.getCurrentUserId();
    List<Category> categories = categoryRepository.findAllByUserId(userId);
    return categories.stream()
      .map(MapperUtil.CATEGORY_MAPPER::toPreviewDto)
      .collect(Collectors.toList());
  }

  @Override
  public CreatedEntityIdDto createCategory(CreateCategoryDto createCategoryDto) {
    User user = internalUserService.getCurrentUser();

    Category category = MapperUtil.CATEGORY_MAPPER.toEntity(createCategoryDto, user);
    Category createdCategory = categoryRepository.saveAndFlush(category);

    Long categoryId = createdCategory.getId();
    return new CreatedEntityIdDto(categoryId);
  }

  @Override
  public CreatedEntityIdDto createCategory(Long accountId, CreateCategoryDto createCategoryDto) {
    User user = internalUserService.getCurrentUser();
    Account account = internalAccountService.getAccount(accountId);

    Category category = MapperUtil.CATEGORY_MAPPER.toEntity(createCategoryDto, user, account);
    Category createdCategory = categoryRepository.save(category);

    Long categoryId = createdCategory.getId();
    return new CreatedEntityIdDto(categoryId);
  }
}
