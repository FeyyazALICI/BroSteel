package com.example.demo.HULL_STEEL.Entity;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceivedHullSteelPojo {

    @JsonProperty("min_width")    // it ensures that the names of the properties in the Java class match the names of the properties in the JSON payload.
    private String minWidth;

    @JsonProperty("max_width")
    private String maxWidth;

    @JsonProperty("min_thickness")
    private String minThickness;

    @JsonProperty("max_thickness")
    private String maxThickness;

    @JsonProperty("carbon_selected")
    private String carbonSelected;

    @JsonProperty("grade_selected")
    private String gradeSelected;
}




