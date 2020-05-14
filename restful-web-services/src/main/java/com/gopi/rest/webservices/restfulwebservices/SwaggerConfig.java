/**
 * Created by gopinath_mb on 12-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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
  private static final Set<String> DEFAULT_CONSUMES_AND_PRODUCES = new HashSet<String>(
      Arrays.asList("application/json", "application/xml"));

  private Contact contact = new Contact("Gopi", "TechJournal",
      "gopinath123@gmail.com");

  private ApiInfo apiInfo = new ApiInfo("Awesome Social Media APP",
      "Enjoy Posting messages", "1.0", "No Terms and Conditions Now", contact,
      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

  @Bean
  public Docket api()
  {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
        .consumes(DEFAULT_CONSUMES_AND_PRODUCES)
        .produces(DEFAULT_CONSUMES_AND_PRODUCES);
  }

}
