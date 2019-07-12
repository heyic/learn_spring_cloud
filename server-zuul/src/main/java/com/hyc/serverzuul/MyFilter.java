package com.hyc.serverzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @Author yche4
 * @Date 2019/4/19 14:04
 **/
@Component
public class MyFilter extends ZuulFilter{
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext currentContext = RequestContext.getCurrentContext();
    String requestURI = currentContext.getRequest().getRequestURI();
    System.out.println("requestURI = " + requestURI);
    return null;
  }
}
