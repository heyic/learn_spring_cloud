package com.hyc.eurekafeign.controller;

import com.hyc.eurekafeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yche4
 * @Date 2019/4/18 19:29
 **/
@RestController
public class TestController {

  @Autowired
  private FeignService feignService;


  @GetMapping("/hi")
  public String getRequestResult(){
    return feignService.getRequestResult();
  }


}
