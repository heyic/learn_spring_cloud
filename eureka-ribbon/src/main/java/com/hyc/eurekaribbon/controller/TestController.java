package com.hyc.eurekaribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author yche4
 * @Date 2019/4/17 16:38
 **/
@RestController
public class TestController {

  @Autowired
  private RestTemplate restTemplate;


  @GetMapping("/hi")
  @HystrixCommand(fallbackMethod = "hiError")
  public String test(){
    return restTemplate.getForObject("http://EUREKA-CLIENT/hi", String.class);
  }

  public String hiError(){
    return "Hi, sorry error";
  }

}
