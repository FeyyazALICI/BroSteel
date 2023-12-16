package com.example.demo.MAIN_CATEGORIES_NON_STEEL.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_categories_non_steel")  // Specify the table name
public class MainCategoriesNonSteelPojo {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "img_path")
    private String img_path;



    public String getName() {
        return this.name;
    }
    public String getImg_path() {
        return this.img_path;
    }



    public void setName(String name) {
        this.name = name;
    }
    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
}
