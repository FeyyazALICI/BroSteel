package com.example.demo.HULL_STEEL.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "hull_steel")  // Specify the table name
public class HullSteelPojo {

    @Id
    private String mpc;
    private int length;
    private int width;
    private int thickness;
    private int density;
    private int hardness;
    private String carbon;
    private int grade;
    private int plant;
}
