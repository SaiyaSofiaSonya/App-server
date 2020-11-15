package org.grigoreva.exeption;

//Собственный класс исключения, наследуется от RuntimeException, чтобы избежать использования Try Catch и обработать Adviser
public class RequestInvalidException extends RuntimeException {

  public RequestInvalidException(String message) {
    super(message);
  }
}
