package com.example.demo.MAIN_CATEGORIES_NON_STEEL.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MAIN_CATEGORIES_NON_STEEL.ENTITY.MainCategoriesNonSteelPojo;
import com.example.demo.MAIN_CATEGORIES_NON_STEEL.REPOSITORY.MainCategoriesNonSteelRepository;

import java.util.*;


@Service
public class MainCategoriesNonSteelService {
    @Autowired
    private MainCategoriesNonSteelRepository mainCategoriesNonSteelRepository;

    public List<MainCategoriesNonSteelPojo> getAllData() {
        return mainCategoriesNonSteelRepository.findAll();
    }
}