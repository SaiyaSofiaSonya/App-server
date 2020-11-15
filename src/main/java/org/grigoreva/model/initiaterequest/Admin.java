package org.grigoreva.model.initiaterequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
@Builder
public class Admin {
    @JsonProperty("Login")
    private String login;
    @JsonProperty("Password")
    private String password;
}
