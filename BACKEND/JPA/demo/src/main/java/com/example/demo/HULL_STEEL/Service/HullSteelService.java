package com.example.demo.HULL_STEEL.Service;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.HULL_STEEL.Entity.HullSteelPojo;
import com.example.demo.HULL_STEEL.Repository.HullSteelRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.*;


@Service
public class HullSteelService {
    @Autowired
    private HullSteelRepository hullSteelRepository;

    @Autowired
    private EntityManager entityManager;  // Inject EntityManager

    public List<HullSteelPojo> getAllData_non_sql() {
        return hullSteelRepository.findAll();
    }

    public List<HullSteelPojo>  getAllData() {
    // Using native SQL query
    String sql = "SELECT * FROM hull_steel";
    Query query = entityManager.createNativeQuery(sql, HullSteelPojo.class);
    return query.getResultList();
    }


    public List<HullSteelPojo> getDataConstraint(int min_width, int max_width, int min_thickness, int max_thickness, String carbon, String grade) {
        // initialization of the data
        if(carbon.equals("ALL")){
            carbon = "%%";
        }
        if(grade.equals("ALL")){
            grade = "%%";
        }

        // Using native SQL query with parameters
        String sql_0 = "SELECT * FROM hull_steel WHERE ";       // Main Statement
        String sql_1 = "width >= :minWidth  AND width <= :maxWidth AND ";        // Width constraint
        String sql_2 = "thickness >= :MinThickness  AND thickness <= :MaxThickness ";        // Thickness constraint
        String sql_3 = "AND carbon LIKE :CARBON  AND grade LIKE :GRADE ";
        String sql_4 = "ORDER BY width DESC";
        String sql = sql_0 + sql_1 + sql_2 + sql_3 + sql_4;

        Query query = entityManager.createNativeQuery(sql, HullSteelPojo.class);
        query.setParameter("minWidth", min_width);
        query.setParameter("maxWidth", max_width);
        query.setParameter("MinThickness", min_thickness);
        query.setParameter("MaxThickness", max_thickness);
        query.setParameter("CARBON", carbon);
        query.setParameter("GRADE", grade);
        return query.getResultList();
    }

    public HullSteelPojo postSingleMPC(String mpc_received){
        String sql = "SELECT * FROM STEEL_DB.hull_steel where mpc = :MPC";
        Query query = entityManager.createNativeQuery(sql, HullSteelPojo.class);
        query.setParameter("MPC", mpc_received);
        return (HullSteelPojo) query.getSingleResult();
    }
}