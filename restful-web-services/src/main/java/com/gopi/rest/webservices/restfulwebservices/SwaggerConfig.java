/**
 * Created by gopinath_mb on 12-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gopinath_mb
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
  @Bean
  public Docket api()
  {
    return new Docket(DocumentationType.SWAGGER_2);
  }

}
