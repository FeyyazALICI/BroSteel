package com.example.demo.MAIN_CATEGORIES_NON_STEEL.REPOSITORY;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.MAIN_CATEGORIES_NON_STEEL.ENTITY.MainCategoriesNonSteelPojo;

public interface MainCategoriesNonSteelRepository extends JpaRepository<MainCategoriesNonSteelPojo, String> {
    // You can add custom query methods here if needed
}
