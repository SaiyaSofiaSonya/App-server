package org.grigoreva.service;

import lombok.extern.slf4j.Slf4j;
import org.grigoreva.exeption.RequestInvalidException;
import org.grigoreva.model.initiaterequest.InitialRequest;
import org.grigoreva.model.RestRequest;
import org.springframework.stereotype.Service;

//Метод для обработки ошибок вслучае некорректного Request с Client
@Slf4j
@Service
public class ValidationService {

  public void validateRequest(RestRequest restRequest) {
    if (restRequest ==null
        || restRequest.getRequest() == null
        || restRequest.getRequest().getUser() == null
        || restRequest.getRequest().getMessage() == null
        || restRequest.getRequest().getMessage() == null
        && restRequest.getRequest().getUser() == null) {
      log.error("Invalid request payload!");
      throw new RequestInvalidException("Invalid request payload!");
    }
  }

  public void validateInitialRequest(InitialRequest initialRequest){

  }
}
