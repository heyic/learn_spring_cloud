package com.hyc.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yche4
 * @Date 2019/4/24 18:12
 **/
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaConfigClientApplication.class, args);
  }


  @Value("${democonfigclient.message}")
  private String foo;

  @RequestMapping("/hi")
  public String getHi(){
    return foo;
  }

}
