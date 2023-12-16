package com.example.demo.HULL_STEEL.Entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;


@Component
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HullSteelMPCPojo {
    
    @JsonProperty("mpc")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String mpc;
}
