package com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "brotein_bar")
public class BroteinBarPojo {
    
    @Id
    private String mpc;
    private String weight;
    private String ingredient;
}
