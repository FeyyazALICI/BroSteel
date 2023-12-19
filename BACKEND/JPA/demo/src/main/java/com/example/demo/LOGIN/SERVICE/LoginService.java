package com.example.demo.LOGIN.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.LOGIN.ENTITY.LoginPojo;
import com.example.demo.LOGIN.ENTITY.LoginResponseDTO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class LoginService {


    @Autowired
    private EntityManager entityManager;

    public List<LoginPojo> getAllData() {
        String sql = "SELECT * FROM USERS";
        Query query = entityManager.createNativeQuery(sql, LoginPojo.class);
        return query.getResultList();
    }

    // By default, each method annotated with @Transactional will run in its own
    // transaction. The transaction will be committed if the method completes
    // successfully
    // and rolled back if an exception is thrown.
    @Transactional
    public ResponseEntity<String> register(String email, String name, String surname, String password, String role) {
        String sql = "INSERT INTO USERS (email, name, surname, password, role) VALUES (:email, :name, :surname, :password, :role)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("email", email);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        query.setParameter("password", password);
        query.setParameter("role", role);

        try {
            int result = query.executeUpdate();
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Successful Registration");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Denied!");
        } catch (Exception e) {
            // Handle specific exceptions if needed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @Transactional
    public ResponseEntity<LoginResponseDTO> checkUser(String email, String password) {
        String sql = "SELECT * FROM USERS WHERE email = :email AND password = :password";
        Query query = entityManager.createNativeQuery(sql, LoginPojo.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try {
            LoginPojo result = (LoginPojo) query.getSingleResult();
            System.out.println("Found");
            System.out.println(result);

            return ResponseEntity.ok(new LoginResponseDTO(result.getRole()));
        } catch (NoResultException e) {
            System.out.println("NOT Found");
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
