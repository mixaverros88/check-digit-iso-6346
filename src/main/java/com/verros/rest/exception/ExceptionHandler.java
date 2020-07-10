package com.verros.rest.exception;

import javax.ws.rs.core.Response;

public class ExceptionHandler {

  public static Response handleException(BusinessException businessException){

    if(businessException.getCode().equals("BAD_REQUEST")){
      return Response.status(Response.Status.BAD_REQUEST).entity(businessException.getMessage()).build();
    }

    return null;
  }

}
