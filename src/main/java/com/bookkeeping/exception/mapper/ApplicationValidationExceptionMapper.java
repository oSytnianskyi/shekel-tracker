package com.bookkeeping.exception.mapper;

import com.bookkeeping.exception.dto.ApplicationExceptionDto;
import com.bookkeeping.exception.ApplicationValidationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class ApplicationValidationExceptionMapper implements ExceptionMapper<ApplicationValidationException> {

  @Override
  public Response toResponse(ApplicationValidationException exception) {
    log.error(exception.getMessage(), exception);
    return Response.status(Response.Status.UNAUTHORIZED)
      .entity(new ApplicationExceptionDto(exception.getMessage()))
      .build();
  }
}
