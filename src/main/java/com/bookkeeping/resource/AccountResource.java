package com.bookkeeping.resource;

import com.bookkeeping.dto.AccountDto;
import com.bookkeeping.service.AccountService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

import static com.bookkeeping.config.Endpoints.ACCOUNTS;

@Path(ACCOUNTS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AccountResource {
  private final AccountService accountService;

  @GET
  public List<AccountDto> getAccounts() {
    return accountService.getAccounts();
  }
}
