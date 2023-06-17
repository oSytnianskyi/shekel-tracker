package com.bookkeeping.exception;

public class ApplicationValidationException extends RuntimeException {
  public ApplicationValidationException() {
    super();
  }

  public ApplicationValidationException(String message) {
    super((message));
  }

  public ApplicationValidationException(String message, Exception e) {
    super(message, e);
  }
}
