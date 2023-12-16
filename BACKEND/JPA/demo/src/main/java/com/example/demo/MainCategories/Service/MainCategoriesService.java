package com.example.demo.MainCategories.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainCategories.Repository.MainCategoriesRepository;
import com.example.demo.MainCategories.Entity.MainCategoriesPojo;
import java.util.*;


@Service
public class MainCategoriesService {
    @Autowired
    private MainCategoriesRepository mainCategoriesRepository;

    public List<MainCategoriesPojo> getAllData() {
        return mainCategoriesRepository.findAll();
    }
}



