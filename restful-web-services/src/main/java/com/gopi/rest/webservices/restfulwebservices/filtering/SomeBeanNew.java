/**
 * Created by gopinath_mb on 13-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author gopinath_mb
 */
@JsonFilter(FilteringDynamicResource.SOME_BEAN_NEW_DYNAMIC_FILTER)  //This enables dynamic filtering
public class SomeBeanNew
{

  private String value1;

  private String value2;

  private String value3;

  /**
   * @param value1
   * @param value2
   * @param value3
   */
  public SomeBeanNew(String value1, String value2, String value3)
  {
    super();
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
  }

  /**
   * @return the value1
   */
  public String getValue1()
  {
    return value1;
  }

  /**
   * @param value1
   *          the value1 to set
   */
  public void setValue1(String value1)
  {
    this.value1 = value1;
  }

  /**
   * @return the value2
   */
  public String getValue2()
  {
    return value2;
  }

  /**
   * @param value2
   *          the value2 to set
   */
  public void setValue2(String value2)
  {
    this.value2 = value2;
  }

  /**
   * @return the value3
   */
  public String getValue3()
  {
    return value3;
  }

  /**
   * @param value3
   *          the value3 to set
   */
  public void setValue3(String value3)
  {
    this.value3 = value3;
  }

}
