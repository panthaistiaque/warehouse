package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.product.BrandModel;
import com.ihit.warehouse.mscproject.product.ProductService;
import com.ihit.warehouse.mscproject.product.UnitService;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/7/2021.
 */
@Controller
public class OrderCtrl extends AppProperty {
    @Autowired
    OrderService orderService;
    @Autowired
    SuppliersService suppliersService;
    @Autowired
    ProductService productService;
    @Autowired
    UnitService unitService;

    @GetMapping(value = "/order_form")
    private ModelAndView getBrand(ModelAndView modelAndView) {
        modelAndView.addObject("order", new Order());
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.addObject("productList", productService.getAllActiveProduct(true));
        modelAndView.addObject("unitList", unitService.getAllActiveUnit(true));
        modelAndView.setViewName("order/order_entry_form");
        return modelAndView;
    }

    @GetMapping(value = "/order_list")
    private ModelAndView getOrderList(ModelAndView modelAndView) {
        modelAndView.addObject("list", orderService.getAll());
        modelAndView.setViewName("order/order_list");
        return modelAndView;
    }

    @PostMapping(value = "/saveOrder")
    private ModelAndView saveOrder(ModelAndView modelAndView, Order order) {
        orderService.save(order);
        modelAndView.setViewName("redirect:/order_list");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/order-details/{id}")
    private Order orderDetails(@PathVariable("id") Integer id) {
        return orderService.getOne(id);
    }


}
