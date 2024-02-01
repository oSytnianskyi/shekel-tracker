package com.stni.shekel.tracker.resource;

import com.group.stnj.tracker.shekel.config.rest.Endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

@Path(Endpoint.TEST)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class TestResource {
  private static final String TEST_MESSAGE = "Test passed";

  @GET
  public String test() {
    return TEST_MESSAGE;
  }
}
