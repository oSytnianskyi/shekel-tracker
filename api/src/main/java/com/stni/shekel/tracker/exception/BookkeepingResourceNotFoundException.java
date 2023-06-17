package com.stni.shekel.tracker.exception;

public class BookkeepingResourceNotFoundException extends RuntimeException {
  public BookkeepingResourceNotFoundException() {
    super();
  }

  public BookkeepingResourceNotFoundException(String message) {
    super((message));
  }

  public BookkeepingResourceNotFoundException(String message, Exception e) {
    super(message, e);
  }
}
