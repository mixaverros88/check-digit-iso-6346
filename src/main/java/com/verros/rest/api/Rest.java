package com.verros.rest.api;

import com.verros.ds.entities.Test;
import com.verros.rest.common.CheckDigit;
import com.verros.rest.dto.CheckDigitDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ManagedBean
@RequestScoped
@Stateless
@Path("/rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Rest {

    @EJB
    Test test;

    @POST
    public Response validateDigit(CheckDigitDto checkDigitDto){
        CheckDigit checkDigit = new CheckDigit();
        Boolean verify =  checkDigit.verify(checkDigitDto.getText());

        test.add(checkDigitDto.getText());
        return Response.status(Response.Status.ACCEPTED).entity(verify.toString()).build();

    }

}