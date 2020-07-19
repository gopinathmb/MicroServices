/**
 * Created by gopinath_mb on 20-May-2020
 */
package com.gopi.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author gopinath_mb
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter
{
  private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

  @Override
  public boolean shouldFilter()
  {
    return true;
  }

  @Override
  public Object run() throws ZuulException
  {
    HttpServletRequest request = RequestContext.getCurrentContext()
        .getRequest();
    logger.info("Request --> {} Request URI -->{}", request,
        request.getRequestURI());
    return null;
  }

  @Override
  public String filterType()
  {
    return "pre";
  }

  @Override
  public int filterOrder()
  {
    return 1;
  }

}
