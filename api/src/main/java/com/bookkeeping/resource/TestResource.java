package com.bookkeeping.resource;

import com.bookkeeping.repository.UserRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class TestResource {

  private final UserRepository userRepository;

  @GET
  public String test() {
    userRepository.test();
    return "Test";
  }
}
