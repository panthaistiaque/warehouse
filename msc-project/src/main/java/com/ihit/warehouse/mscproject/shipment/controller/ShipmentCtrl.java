package com.ihit.warehouse.mscproject.shipment.controller;

import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by User on 2/27/2021.
 */
@Controller
public class ShipmentCtrl {
    @Autowired
    SuppliersService suppliersService;
    @GetMapping("/new-shipment")
    public ModelAndView newShipment(final ModelAndView modelAndView) {
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.setViewName("shipment/new_shipment_form");
        return modelAndView;
    }

    @PostMapping("/save-shipment")
    public ModelAndView saveShipment(@RequestBody Map<String, Object> shipment){
        ModelAndView modelAndView =  new ModelAndView();
        System.out.println(shipment);
        modelAndView.setViewName("redirect:/new-shipment");
        return modelAndView;
    }
}
