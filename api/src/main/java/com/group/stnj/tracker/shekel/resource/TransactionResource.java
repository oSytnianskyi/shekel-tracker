package com.group.stnj.tracker.shekel.resource;

import com.group.stnj.tracker.shekel.config.rest.Endpoint;
import com.group.stnj.tracker.shekel.dto.CreateTransactionDto;
import com.group.stnj.tracker.shekel.manager.TransactionManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

@Path(Endpoint.TRANSACTIONS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class TransactionResource {
  private final TransactionManager transactionManager;

  @POST
  @Path("/")
  public String create(CreateTransactionDto dto) {
    return transactionManager.create(dto);
  }
}
