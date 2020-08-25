package com.verros.rest.inter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class TrakingInterceptor {

  @AroundInvoke
  public void aroundInvoke(InvocationContext context){
    System.out.println("Test");

  }

}
