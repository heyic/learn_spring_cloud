package com.hyc.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.Configuration;

/**
 * @Author yche4
 * @Date 2019/4/22 20:09
 **/
@SpringBootApplication
@RestController
public class ConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }

  @Value("${democonfigclient.message}")
  private String foo;

  @RequestMapping("/hi")
  public String getHi(){
    return foo;
  }
}
