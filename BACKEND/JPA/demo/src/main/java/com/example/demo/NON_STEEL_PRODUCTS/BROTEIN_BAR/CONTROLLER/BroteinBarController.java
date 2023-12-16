package com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.ENTITY.BroteinBarPojo;
import com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.ENTITY.ReceivedBroteinBar;
import com.example.demo.NON_STEEL_PRODUCTS.BROTEIN_BAR.SERVICE.BroteinBarService;

@RestController
@RequestMapping("/brotein_bar")
public class BroteinBarController {
    @Autowired
    private BroteinBarService broteinBarService;

    @GetMapping("")
    public List<BroteinBarPojo> getAllData(){
        return broteinBarService.getAllData();
    }


    @PostMapping("/constraintData")
    public List<BroteinBarPojo> filterByWidth(@RequestBody ReceivedBroteinBar received_data) {
        int weight = Integer.parseInt(received_data.getWeight());
        String ingredient = received_data.getIngredient();
        return broteinBarService.getDataConstraint(weight, ingredient);
    }
}
