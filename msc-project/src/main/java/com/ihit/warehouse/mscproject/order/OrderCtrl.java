package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.product.BrandModel;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/7/2021.
 */
@Controller
public class OrderCtrl extends AppProperty {
    @Autowired
    SuppliersService suppliersService;
    @GetMapping(value = "/order_form")
    private ModelAndView getBrand(ModelAndView modelAndView){
        OrderDtl order =new OrderDtl();
        order.setOrderQty(2);
        OrderDtl order2 =new OrderDtl();
        order2.setOrderQty(4);
        List<OrderDtl> dtls = new ArrayList<>();
        dtls.add(order);
        dtls.add(order2);
        Order order1 = new Order();
        order1.setDtl(dtls);
        modelAndView.addObject("order",order1);
        modelAndView.addObject("suppliersList",suppliersService.findAll());
        modelAndView.setViewName("order/order_entry_form");
        return modelAndView;
    }
}
