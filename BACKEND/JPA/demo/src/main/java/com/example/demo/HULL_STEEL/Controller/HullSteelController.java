package com.example.demo.HULL_STEEL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.HULL_STEEL.Entity.HullSteelMPCPojo;
import com.example.demo.HULL_STEEL.Entity.HullSteelPojo;
import com.example.demo.HULL_STEEL.Entity.ReceivedHullSteelPojo;
import com.example.demo.HULL_STEEL.Service.HullSteelService;

import java.util.List;


@RestController
@RequestMapping("/hull_steel")
public class HullSteelController {
    @Autowired
    private HullSteelService hullSteelService;

    @Autowired
    private ReceivedHullSteelPojo receivedHullSteelPojo;
    @GetMapping
    public Iterable<HullSteelPojo> getAllData() {
        // Using native SQL query
        return hullSteelService.getAllData();
    }

    @PostMapping("/constraintData")
    public List<HullSteelPojo> filterByWidth(@RequestBody ReceivedHullSteelPojo received_data) {
        ReceivedHullSteelPojo  data = received_data;
        int min_width = Integer.parseInt(data.getMinWidth());
        int max_width = Integer.parseInt(data.getMaxWidth());
        int min_thickness = Integer.parseInt(data.getMinWidth());
        int max_thickness = Integer.parseInt(data.getMaxThickness());
        String carbon = data.getCarbonSelected();
        String grade = data.getGradeSelected();

        return hullSteelService.getDataConstraint(min_width, max_width, min_thickness, max_thickness, carbon, grade);

    }

    @PostMapping("/singleMPC")
    public HullSteelPojo singleMPC(@RequestBody HullSteelMPCPojo received_data){
        String mpc = received_data.getMpc();
        System.out.println(received_data);
        return hullSteelService.postSingleMPC(mpc);
    }
}