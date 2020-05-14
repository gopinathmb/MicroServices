/**
 * Created by gopinath_mb on 13-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gopinath_mb
 */
@RestController
public class FilteringResource
{

  @GetMapping("/filtering")
  public SomeBean retrieveSomeBean()
  {
    return new SomeBean("value1", "value2", "value3");
  }

  @GetMapping("/filtering-list")
  public List<SomeBean> retrieveSomeBeanList()
  {
    return Arrays.asList(new SomeBean("value1", "value2", "value3"),
        new SomeBean("value4", "value5", "value6"));
  }

}
