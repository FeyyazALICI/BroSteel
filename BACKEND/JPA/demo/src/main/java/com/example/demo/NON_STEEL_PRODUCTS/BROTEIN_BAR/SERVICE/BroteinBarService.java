package com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.SERVICE;

import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;

import java.util.List; // Corrected import for List

import com.example.demo.HULL_STEEL.Entity.HullSteelPojo;
import com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.ENTITY.BroteinBarPojo;


@Service
public class BroteinBarService {
    @Autowired
    private EntityManager entityManager;

    public List<BroteinBarPojo> getAllData(){
        String sql ="SELECT * FROM brotein_bar";
        Query query = entityManager.createNativeQuery(sql, BroteinBarPojo.class);
        return query.getResultList();
    }

    public List<BroteinBarPojo> getDataConstraint(int weight, String ingredient) {
        // initialization of the data
        int min_weight;
        int max_weight;
        if(weight != 0){
            min_weight = weight;
            max_weight = weight;
        }else{
            min_weight = 0;
            max_weight = 1000000;            
        }

        if(ingredient.equals("ALL")){
            ingredient = "%%";
        }

        // Using native SQL query with parameters
        String sql_0 = "SELECT * FROM brotein_bar WHERE ";       // Main Statement
        String sql_1 = "weight >= :minWeight  AND weight <= :maxWeight AND ";        // Width constraint
        String sql_2 = "ingredient LIKE :Ingredient ";        // Thickness constraint
        String sql_3 = "ORDER BY weight DESC";
        String sql = sql_0 + sql_1 + sql_2 + sql_3;

        Query query = entityManager.createNativeQuery(sql, BroteinBarPojo.class);
        query.setParameter("minWeight", min_weight);
        query.setParameter("maxWeight", max_weight);
        query.setParameter("Ingredient", ingredient);
        return query.getResultList();
    }


}
