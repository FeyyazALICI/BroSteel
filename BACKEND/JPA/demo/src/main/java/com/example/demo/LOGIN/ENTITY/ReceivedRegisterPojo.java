package com.example.demo.LOGIN.ENTITY;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceivedRegisterPojo {
    
    @JsonProperty("email")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String email;

    @JsonProperty("name")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String name;

    @JsonProperty("surname")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String surname;

    @JsonProperty("password")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String password;

    @JsonProperty("role")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String role;
}
