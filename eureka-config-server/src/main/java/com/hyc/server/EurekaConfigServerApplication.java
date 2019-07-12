package com.hyc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author yche4
 * @Date 2019/4/23 19:55
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableConfigServer
public class EurekaConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaConfigServerApplication.class, args);
  }

}
