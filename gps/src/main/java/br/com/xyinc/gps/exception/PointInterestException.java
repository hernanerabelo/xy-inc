package br.com.xyinc.gps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PointInterestException extends RuntimeException {

  public PointInterestException( String message ) {
    super( message );
  }

  public PointInterestException( String message, Throwable cause ) {
    super( message, cause );
  }

}
