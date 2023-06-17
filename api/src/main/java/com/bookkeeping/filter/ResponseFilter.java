package com.bookkeeping.filter;

import com.bookkeeping.config.ContainerFilterConstants;

import org.slf4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseFilter implements ContainerResponseFilter {
  @Override
  public void filter(
    ContainerRequestContext containerRequestContext,
    ContainerResponseContext containerResponseContext
  ) {
    MDC.remove(ContainerFilterConstants.USER_EMAIL);
    MDC.remove(ContainerFilterConstants.X_AMZN_TRACE_ID);
  }
}
