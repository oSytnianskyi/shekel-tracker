package com.bookkeeping.exception.mapper;

import com.bookkeeping.exception.BookkeepingResourceNotFoundException;
import com.bookkeeping.exception.dto.ApplicationExceptionDto;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class BookkeepingResourceNotFoundExceptionMapper implements ExceptionMapper<BookkeepingResourceNotFoundException> {

  @Override
  public Response toResponse(BookkeepingResourceNotFoundException exception) {
    log.error(exception.getMessage(), exception);
    return Response.status(Response.Status.NOT_FOUND)
      .entity(new ApplicationExceptionDto(exception.getMessage()))
      .build();
  }
}
