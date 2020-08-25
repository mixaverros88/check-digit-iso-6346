package com.verros.rest.inter;

import org.apache.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Audited
@Interceptor
public class TrackingInterceptor {

  static final Logger logger = Logger.getLogger(TrackingInterceptor.class);

  @AroundInvoke
  public Object methodInterceptor(InvocationContext ctx) throws Exception {

    logger.debug("*** Intercepting call to LibraryBean method: "
      + ctx.getMethod().getName());
    return ctx.proceed();
  }

}
