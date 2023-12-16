package com.example.demo.MainCategories.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MainCategories.Entity.MainCategoriesPojo;
import com.example.demo.MainCategories.Service.MainCategoriesService;


@RestController
@RequestMapping("/main_categories")
public class MainCategoriesController {
    @Autowired
    private MainCategoriesService mainCategoriesService;

    @GetMapping
    public Iterable<MainCategoriesPojo> getAllDepartments() {
        return mainCategoriesService.getAllData();
    }
}


