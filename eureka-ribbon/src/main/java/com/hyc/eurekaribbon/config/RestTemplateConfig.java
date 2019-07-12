package com.hyc.eurekaribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author yche4
 * @Date 2019/4/17 16:32
 **/
@Configuration
public class RestTemplateConfig {

  @Bean(name = "restTemplate")
  @LoadBalanced
  public RestTemplate getRestTemplate(){
      return new RestTemplate();
  }

}
