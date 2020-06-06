package com.verros.api;

import com.verros.common.CheckDigit;
import com.verros.dto.CheckDigitDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Rest {

    @POST
    public Response validateDigit(CheckDigitDto checkDigitDto){
        CheckDigit checkDigit = new CheckDigit();
        Boolean verify =  checkDigit.verify(checkDigitDto.getText());
        return Response.status(Response.Status.ACCEPTED).entity(verify.toString()).build();

    }

}