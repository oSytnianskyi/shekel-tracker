package com.stni.shekel.tracker.resource;

import com.stni.shekel.tracker.config.Endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

@Path(Endpoints.TEST)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class TestResource {

  @GET
  public String test() {
    return "Test";
  }
}
