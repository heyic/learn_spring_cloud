package com.hyc.eurekafeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author yche4
 * @Date 2019/4/18 19:29
 **/
@FeignClient(name = "eureka-client", fallback = FeignServiceHystrix.class)
public interface FeignService {

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  String getRequestResult();

}
