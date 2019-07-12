package com.hyc.eurekaribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author yche4
 * @Date 2019/4/17 13:47
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class EurekaRibbonApplication {

  public static void main(String[] args) {
      SpringApplication.run(EurekaRibbonApplication.class, args);
  }

}
