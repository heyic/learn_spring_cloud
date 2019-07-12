package com.hyc.hystrix;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixDashboardTwoApplication {


    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardTwoApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String dashBoardTwoHi(@RequestParam(value = "name", defaultValue="hyc") String name){
        String result = restTemplate.getForObject("http://EUREKA-CLIENT/hi", String.class);
        return "hi " + name + " " + result;
    }


    @RequestMapping("/hi1")
    @HystrixCommand(fallbackMethod = "hiError")
    public String dashBoardTwoHi1(@RequestParam(value = "name", defaultValue="hyc") String name){
        String result = restTemplate.getForObject("http://EUREKA-CLIENT/hi", String.class);
        return "hi " + name + " " + result;
    }
    public String hiError(String name){
        return "hi " + name + " sorry, error";
    }

    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ServletRegistrationBean getServlet(){

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);

        registrationBean.addUrlMappings("/actuator/hystrix.stream");

        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean;
    }
}
