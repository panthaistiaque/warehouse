package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.product.BrandModel;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 9/7/2021.
 */
@Controller
public class OrderCtrl extends AppProperty {
    @Autowired
    SuppliersService suppliersService;
    @GetMapping(value = "/order_form")
    private ModelAndView getBrand(ModelAndView modelAndView){
        modelAndView.addObject("order",new Order());
        modelAndView.addObject("suppliersList",suppliersService.findAll());
        modelAndView.setViewName("order/order_entry_form");
        return modelAndView;
    }
}
