package com.example.demo.LOGIN.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.LOGIN.ENTITY.LoginPojo;

public interface LoginRepository extends JpaRepository<LoginPojo, Integer>{
    
}


