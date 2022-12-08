package com.bookkeeping.resource;

import com.bookkeeping.dto.CategoryPreviewDto;
import com.bookkeeping.dto.CreateCategoryDto;
import com.bookkeeping.dto.CreatedEntityIdDto;
import com.bookkeeping.service.CategoryService;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

import static com.bookkeeping.config.Endpoints.CATEGORIES;

@Path(CATEGORIES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class CategoryResource {
  private final CategoryService categoryService;

  @GET
  public List<CategoryPreviewDto> getCategoriesPreview() {
    return categoryService.getCategoriesPreview();
  }

  @POST
  public CreatedEntityIdDto createCategory(@Valid CreateCategoryDto createCategoryDto) {
    return categoryService.createCategory(createCategoryDto);
  }
}
