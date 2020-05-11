/**
 * Created by gopinath_mb on 10-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.exception;

import java.util.Date;

/**
 * @author gopinath_mb
 */
public class ExceptionResponse
{
  private Date timeStamp;

  private String message;

  private String details;

  /**
   * @param timeStamp
   * @param message
   * @param details
   */
  public ExceptionResponse(Date timeStamp, String message, String details)
  {
    super();
    this.timeStamp = timeStamp;
    this.message = message;
    this.details = details;
  }

  /**
   * @return the timeStamp
   */
  public Date getTimeStamp()
  {
    return timeStamp;
  }

  /**
   * @param timeStamp
   *          the timeStamp to set
   */
  public void setTimeStamp(Date timeStamp)
  {
    this.timeStamp = timeStamp;
  }

  /**
   * @return the message
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * @param message
   *          the message to set
   */
  public void setMessage(String message)
  {
    this.message = message;
  }

  /**
   * @return the details
   */
  public String getDetails()
  {
    return details;
  }

  /**
   * @param details
   *          the details to set
   */
  public void setDetails(String details)
  {
    this.details = details;
  }

}
