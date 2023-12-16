package com.example.demo.LOGIN.CONTROLLER;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LOGIN.ENTITY.LoginPojo;
import com.example.demo.LOGIN.ENTITY.LoginResponseDTO;
import com.example.demo.LOGIN.ENTITY.ReceivedRegisterPojo;
import com.example.demo.LOGIN.ENTITY.ReceivedUserCheckPojo;
import com.example.demo.LOGIN.SERVICE.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public Iterable<LoginPojo> getAllData() {
        return loginService.getAllData();
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody ReceivedRegisterPojo received_data) {
        String email = received_data.getEmail();
        String name = received_data.getName();
        String surname = received_data.getSurname();
        String password = received_data.getPassword();
        String role = received_data.getRole();
        return loginService.register(email, name, surname, password, role);
    }

    @PostMapping("/check_user")
    public ResponseEntity<LoginResponseDTO> checkUser(@RequestBody ReceivedUserCheckPojo received_data) {
        String email = received_data.getEmail();
        String password = received_data.getPassword();
        return loginService.checkUser(email, password);
    }
}
