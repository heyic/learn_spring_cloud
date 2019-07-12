package com.hyc.eurekafeign.service;

import org.springframework.stereotype.Component;

/**
 * @Author yche4
 * @Date 2019/4/19 10:15
 **/
@Component
public class FeignServiceHystrix implements FeignService{

  @Override
  public String getRequestResult() {
    return "Hi, sorry error";
  }


}
