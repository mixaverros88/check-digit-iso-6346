package com.verros.rest.api;

import com.verros.ds.management.DatabaseManagement;
import com.verros.ds.entities.CheckDigitJpo;
import com.verros.rest.common.CheckDigit;
import com.verros.rest.dto.CheckDigitDto;
import com.verros.rest.process.BusinessProcess;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Rest {

  @Inject
  DatabaseManagement databaseManagement;

  @POST
  public Response validateDigit(CheckDigitDto checkDigitDto) {
    BusinessProcess businessProcess = new BusinessProcess();
    Boolean verify = businessProcess.validate(checkDigitDto);

    databaseManagement.add(checkDigitDto.getText());

    return Response.status(Response.Status.CREATED).entity(verify.toString()).build();

  }

  @GET
  public Response getAllChecks(){
    List<CheckDigitJpo> checkDigitList = databaseManagement.getAll();

    return Response.status(Response.Status.OK).entity(checkDigitList).build();
  }

  @DELETE
  @Path("/{id}")
  public  Response delete(@PathParam("id") Integer id){
    databaseManagement.delete(id);

    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @PUT
  public Response update(CheckDigitDto checkDigitDto){
    databaseManagement.update(checkDigitDto);

    return Response.status(Response.Status.OK).build();
  }


}
