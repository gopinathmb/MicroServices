package com.gopi.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;

import brave.sampler.Sampler;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
  }

  //For Tracing
  @Bean
  public Sampler defaultSample()
  {
    return Sampler.ALWAYS_SAMPLE;
  }
  
}
