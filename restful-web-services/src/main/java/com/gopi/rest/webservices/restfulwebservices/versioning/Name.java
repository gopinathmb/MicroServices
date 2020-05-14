/**
 * Created by gopinath_mb on 13-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.versioning;

/**
 * @author gopinath_mb
 */
public class Name
{

  private String firstName;

  private String lastName;

  /**
   * @param firstName
   * @param lastName
   */
  public Name(String firstName, String lastName)
  {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return the firstName
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * @param firstName
   *          the firstName to set
   */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * @param lastName
   *          the lastName to set
   */
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

}
