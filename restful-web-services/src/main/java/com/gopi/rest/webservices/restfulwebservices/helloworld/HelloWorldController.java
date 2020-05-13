/**
 * Created by gopinath_mb on 09-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gopinath_mb
 */
//Below annotation says that it is a rest controller.
@RestController
public class HelloWorldController
{

  @Autowired
  private MessageSource messageSource;

  // Any end point should be annotatated with either of then and provide type
  // and uri
  // U can use either RequestMapping or GetMapping.GetMapping is simple.
  // @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
  @GetMapping(path = "/hello-world")
  public String helloWorld()
  {
    return "Hello World";
  }

  // Internationalization //accept-language will be passed when u invoking the
  // method
  @GetMapping(path = "/hello-world-i18n")
  public String helloWorldI18n()
  {
    // LocaleContextHolder.getLocale() " this is because of
    // com.gopi.rest.webservices.restfulwebservices.RestfulWebServicesApplication.localeResolver()
    // with AcceptHeaderLocaleResolver
    return messageSource.getMessage("good.morning.message", null,
        LocaleContextHolder.getLocale());
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean()
  {
    return new HelloWorldBean("Hello World From Bean");
  }

  /// hello-world/path-variable/gopi
  @GetMapping(path = "/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
  {
    return new HelloWorldBean(
        String.format("Hello World with Path Variable : %s", name));
  }

}
