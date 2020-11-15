package org.grigoreva.service;

import lombok.extern.slf4j.Slf4j;
import org.grigoreva.exeption.RequestInvalidException;
import org.grigoreva.model.initiaterequest.InitialRequest;
import org.grigoreva.model.RestRequest;
import org.springframework.stereotype.Service;

//Метод для обработки ошибок вслучае некорректного Request с Client
@Slf4j //
@Service
public class ValidationService {

  public void validateRequest(RestRequest restRequest) {
    if (restRequest ==null
        || restRequest.getRequest() == null
        || restRequest.getRequest().getUser() == null
        || restRequest.getRequest().getMessage() == null) {
      throw new RequestInvalidException("Невалидное значение request payload!");
    }
  }

  public void validateInitialRequest(InitialRequest initialRequest){
    if (initialRequest ==null
            || initialRequest.getAdmin() == null
            || initialRequest.getAdmin().getLogin() == null
            ||initialRequest.getAdmin().getPassword() == null) {
      throw new RequestInvalidException("Невалидное значение request payload!");
    }
  }
}
