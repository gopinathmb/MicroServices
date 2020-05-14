/**
 * Created by gopinath_mb on 13-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.versioning;

/**
 * @author gopinath_mb
 */
public class PersonV1
{
  private String name;

  /**
   * @param name
   */
  public PersonV1(String name)
  {
    super();
    this.name = name;
  }

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }
}
