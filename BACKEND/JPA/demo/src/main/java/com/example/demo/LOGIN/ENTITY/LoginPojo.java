package com.example.demo.LOGIN.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class LoginPojo {

    @Id
    private int id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private String role;


}
