package com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.ENTITY;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceivedBroteinBar {
    
    @JsonProperty("weight")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String weight;
    @JsonProperty("ingredient")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String ingredient;
}
