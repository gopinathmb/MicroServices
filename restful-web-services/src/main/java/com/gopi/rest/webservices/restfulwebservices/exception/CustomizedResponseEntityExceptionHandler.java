/**
 * Created by gopinath_mb on 10-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gopi.rest.webservices.restfulwebservices.user.UserNotFoundException;

/**
 * @author gopinath_mb
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler
{

  // Default Exception handler
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException(Exception ex,
      WebRequest request)
  {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
        ex.getMessage(), request.getDescription(false));
    ResponseEntity responseEntity = new ResponseEntity(exceptionResponse,
        HttpStatus.INTERNAL_SERVER_ERROR);

    return responseEntity;
  }

//Specific Exception handler
  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> handleUseotFoundException(
      UserNotFoundException ex, WebRequest request)
  {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
        ex.getMessage(), request.getDescription(false));
    ResponseEntity responseEntity = new ResponseEntity(exceptionResponse,
        HttpStatus.NOT_FOUND);

    return responseEntity;
  }
}
