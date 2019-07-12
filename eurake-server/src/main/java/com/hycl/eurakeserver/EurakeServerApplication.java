package com.hycl.eurakeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author yche4
 * @Date 2019/4/17 9:57
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurakeServerApplication {

  public static void main(String[] args){
    SpringApplication.run(EurakeServerApplication.class, args);
  }
}
