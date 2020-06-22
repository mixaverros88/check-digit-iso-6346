package com.verros.rest.api;

import com.verros.ds.DatabaseManagement;
import com.verros.rest.common.CheckDigit;
import com.verros.rest.dto.CheckDigitDto;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Rest {

  @Inject
  DatabaseManagement databaseManagement;

  @POST
  public Response validateDigit(CheckDigitDto checkDigitDto) {
    CheckDigit checkDigit = new CheckDigit();
    Boolean verify = checkDigit.verify(checkDigitDto.getText());

    databaseManagement.add(checkDigitDto.getText());
    return Response.status(Response.Status.ACCEPTED).entity(verify.toString()).build();

  }

}
