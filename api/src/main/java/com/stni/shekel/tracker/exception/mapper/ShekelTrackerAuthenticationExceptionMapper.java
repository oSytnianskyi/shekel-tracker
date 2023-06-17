package com.stni.shekel.tracker.exception.mapper;

import com.stni.shekel.tracker.exception.ShekelTrackerAuthenticationException;
import com.stni.shekel.tracker.exception.dto.ApplicationExceptionDto;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class ShekelTrackerAuthenticationExceptionMapper implements ExceptionMapper<ShekelTrackerAuthenticationException> {

  @Override
  public Response toResponse(ShekelTrackerAuthenticationException exception) {
    log.error(exception.getMessage(), exception);
    return Response.status(Response.Status.UNAUTHORIZED)
      .entity(new ApplicationExceptionDto(exception.getMessage()))
      .build();
  }
}
