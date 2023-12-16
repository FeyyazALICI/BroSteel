package com.example.demo.MAIN_CATEGORIES_NON_STEEL.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MAIN_CATEGORIES_NON_STEEL.ENTITY.MainCategoriesNonSteelPojo;
import com.example.demo.MAIN_CATEGORIES_NON_STEEL.SERVICE.MainCategoriesNonSteelService;




@RestController
@RequestMapping("/main_categories_non_steel")
public class MainCategoriesNonSteelController {
    @Autowired
    private MainCategoriesNonSteelService mainCategoriesNonSteelService;

    @GetMapping
    public Iterable<MainCategoriesNonSteelPojo> getAllDepartments() {
        return mainCategoriesNonSteelService.getAllData();
    }
}