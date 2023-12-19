package com.example.demo.LOGIN.ENTITY;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LoginResponseDTO {
    @Id
    private String role;

    public LoginResponseDTO(String role) {
        this.role = role;
    }
}
