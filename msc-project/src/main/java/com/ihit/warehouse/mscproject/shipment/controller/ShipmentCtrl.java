package com.ihit.warehouse.mscproject.shipment.controller;

import com.ihit.warehouse.mscproject.shipment.service.ShipmentService;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    ShipmentService shipmentService;
    @Autowired
    SuppliersService suppliersService;

    @GetMapping("/new-shipment")
    public ModelAndView newShipment(final ModelAndView modelAndView, @AuthenticationPrincipal User currentUser) {
        modelAndView.addObject("suppliersList", suppliersService.findAll());
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName("shipment/new_shipment_form");
        return modelAndView;
    }

    @GetMapping("/all-shipment")
    public ModelAndView getAllShipment(final ModelAndView modelAndView, @AuthenticationPrincipal User currentUser) {
        modelAndView.addObject("suppliersList", shipmentService.getAllOrders());
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName("shipment/order_list");
        return modelAndView;
    }

    @GetMapping("/order-froward/{id}")
    public ModelAndView orderFroward(final ModelAndView modelAndView, @AuthenticationPrincipal User currentUser, @PathVariable("id") Integer id) {
        shipmentService.orderFroward(id);
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName("redirect:/all-shipment");
        return modelAndView;
    }

    @GetMapping("/order-delete/{id}")
    public ModelAndView orderDelete(final ModelAndView modelAndView, @AuthenticationPrincipal User currentUser, @PathVariable("id") Integer id) {
        shipmentService.deleteOrders(id);
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName("redirect:/all-shipment");
        return modelAndView;
    }

    @GetMapping("/order-edit/{id}")
    public ModelAndView orderEdit(final ModelAndView modelAndView, @AuthenticationPrincipal User currentUser, @PathVariable("id") Integer id) {
        modelAndView.addObject("user", currentUser);
        modelAndView.setViewName("redirect:/new-shipment?id=" + id);
        return modelAndView;
    }

    @PostMapping("/save-shipment")
    public ModelAndView saveShipment(@RequestBody Map<String, Object> shipment) {
        ModelAndView modelAndView = new ModelAndView();
        shipmentService.saveShipment(shipment);
        modelAndView.setViewName("redirect:/all-shipment");
        return modelAndView;
    }
}
