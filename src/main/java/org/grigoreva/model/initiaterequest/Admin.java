package org.grigoreva.model.initiaterequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Модель данныx, аннотации ниже для вызова конструктора, геттеров и сеттеров без их явного создания (Lombok)
@Data
@Builder
//@NoArgsConstructor
public class Admin {
    @JsonProperty("Login")
    private String login;
    @JsonProperty("Password")
    private String password;
}
