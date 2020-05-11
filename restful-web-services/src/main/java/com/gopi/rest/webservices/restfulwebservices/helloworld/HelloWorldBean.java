/**
 * Created by gopinath_mb on 09-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.helloworld;

/**
 * @author gopinath_mb
 */
public class HelloWorldBean
{

  private String message;

  public HelloWorldBean(String message)
  {
    this.setMessage(message);
  }

  /**
   * @return the message
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message)
  {
    this.message = message;
  }
}
