/**
 * Created by gopinath_mb on 13-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author gopinath_mb
 */
@RestController
public class FilteringDynamicResource
{

  /**
   * 
   */
  public static final String SOME_BEAN_NEW_DYNAMIC_FILTER = "SomeBeanNewDynamicFilter";

  @GetMapping("/filteringDynamic")
  public MappingJacksonValue retrieveSomeBean()
  {
    SomeBeanNew someBeanNew = new SomeBeanNew("value1", "value2", "value3");

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
        .filterOutAllExcept("value1", "value3");
    FilterProvider filters = new SimpleFilterProvider()
        .addFilter(SOME_BEAN_NEW_DYNAMIC_FILTER, filter);

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(
        someBeanNew);
    mappingJacksonValue.setFilters(filters);

    return mappingJacksonValue;
  }

  @GetMapping("/filteringDynamic-list")
  public MappingJacksonValue retrieveSomeBeanList()
  {
    List<SomeBeanNew> asList = Arrays.asList(
        new SomeBeanNew("value1", "value2", "value3"),
        new SomeBeanNew("value4", "value5", "value6"));
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
        .filterOutAllExcept("value1", "value3");
    FilterProvider filters = new SimpleFilterProvider()
        .addFilter(SOME_BEAN_NEW_DYNAMIC_FILTER, filter);

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
    mappingJacksonValue.setFilters(filters);

    return mappingJacksonValue;
  }

}
