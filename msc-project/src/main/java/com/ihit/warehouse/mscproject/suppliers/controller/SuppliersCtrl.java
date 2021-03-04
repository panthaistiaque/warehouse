package com.ihit.warehouse.mscproject.suppliers.controller;

import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 2/21/2021.
 */
@Controller
public class SuppliersCtrl {
    @Autowired
    SuppliersService suppliersService;

    @GetMapping("/new-supplier")
    public ModelAndView newSupplier( final  ModelAndView modelAndView) {
        modelAndView.addObject("suppliers", new Suppliers());
        modelAndView.setViewName( "supplier/suppliers_entry_form");
        return modelAndView;
    }

    @GetMapping("/supplier-list")
    public ModelAndView supplierList(  final  ModelAndView modelAndView) {
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.setViewName(  "supplier/suppliers_list");
        return modelAndView;
    }

    @PostMapping("/saveSuppliers")
    public ModelAndView saveUser(final ModelAndView model, Suppliers suppliers) {
        suppliersService.save(suppliers);
        model.setViewName("redirect:/supplier-list");
        return model;
    }
}
