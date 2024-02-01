package com.stni.shekel.tracker.filter;

import com.stni.shekel.tracker.config.ContainerFilterConstants;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class RequestFilter implements ContainerRequestFilter {

//  InternalUserService internalUserService;

  @Override
  public void filter(ContainerRequestContext context) {
    if (shouldSkipFiltering(context)) {
      return;
    }
    MDC.put(ContainerFilterConstants.X_AMZN_TRACE_ID, getTraceId(context.getHeaderString(ContainerFilterConstants.X_AMZN_TRACE_ID)));
    String email = " test - mail =";
    MDC.put(ContainerFilterConstants.USER_EMAIL, email);
  }

  private String getTraceId(String header) {
    if (StringUtils.isEmpty(header)) {
      return "No " + ContainerFilterConstants.X_AMZN_TRACE_ID;
    }
    String[] tokenParts = header.split("=", -1);
    return tokenParts.length == 2 ? tokenParts[1] : tokenParts[0];
  }

  private boolean shouldSkipFiltering(ContainerRequestContext context) {
    return context.getUriInfo().getPath().contains("Endpoints.DATABASE");
  }
}
