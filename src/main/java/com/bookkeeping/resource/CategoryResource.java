package com.bookkeeping.resource;

import com.bookkeeping.service.CategoryService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
  public List<String> getCategoriesNames() {
    return categoryService.getCategoriesNames();
  }
}
