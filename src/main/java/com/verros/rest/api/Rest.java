package com.verros.rest.api;

import com.verros.ds.management.DatabaseManagement;
import com.verros.ds.entities.CheckDigitJpo;
import com.verros.rest.dto.CheckDigitDto;
import com.verros.rest.dto.CheckDigitResponseDto;
import com.verros.rest.exception.BusinessException;
import com.verros.rest.exception.ExceptionHandler;
import com.verros.rest.inter.Audited;
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
@Audited
public class Rest {

  @Inject
  DatabaseManagement databaseManagement;

  @POST
  public Response validateDigit(CheckDigitDto checkDigitDto) {
    BusinessProcess businessProcess = new BusinessProcess();
    Boolean verify = businessProcess.validate(checkDigitDto);

    Long id = databaseManagement.add(checkDigitDto.getText());

    CheckDigitResponseDto checkDigitResponseDto = new CheckDigitResponseDto();
    checkDigitResponseDto.setId(id);
    checkDigitResponseDto.setValidateStatus(verify);

    return Response.status(Response.Status.CREATED).entity(checkDigitResponseDto).build();

  }

  @GET
  public Response getAllChecks(){
    List<CheckDigitJpo> checkDigitList = databaseManagement.getAll();

    return Response.status(Response.Status.OK).entity(checkDigitList).build();
  }

  @DELETE
  @Path("/{id}")
  public  Response delete(@PathParam("id") Integer id){
    try {
      databaseManagement.delete(id);
    } catch (BusinessException e) {
      e.printStackTrace();
      return ExceptionHandler.handleException(e);
    }
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @PUT
  @Path("/{id}")
  public Response update(@PathParam("id") Integer id, CheckDigitDto checkDigitDto){
    checkDigitDto.setId(id);
    databaseManagement.update(checkDigitDto);

    return Response.status(Response.Status.OK).build();
  }


}
