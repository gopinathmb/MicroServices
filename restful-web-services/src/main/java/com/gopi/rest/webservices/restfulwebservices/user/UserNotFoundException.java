/**
 * Created by gopinath_mb on 10-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author gopinath_mb
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  /**
   * @param message
   */
  public UserNotFoundException(String message)
  {
    super(message);
  }

}
