package com.example.demo.MainCategories.Repository;

import com.example.demo.MainCategories.Entity.MainCategoriesPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCategoriesRepository extends JpaRepository<MainCategoriesPojo, String> {
    
}
