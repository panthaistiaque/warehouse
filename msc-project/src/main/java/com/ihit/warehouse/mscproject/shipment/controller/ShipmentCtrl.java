package com.ihit.warehouse.mscproject.shipment.controller;

import com.ihit.warehouse.mscproject.shipment.service.ShipmentService;
import com.ihit.warehouse.mscproject.suppliers.service.SuppliersService;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/vendor-singup")
    public ModelAndView shopkeeperLogin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        String token = request.getParameter("tk");
        String validity = request.getParameter("v");
        String orderId = request.getParameter("i");
        System.out.println(token+":::"+validity+":::"+orderId);
        if (token != "" && validity != "") {
            Long time = Long.valueOf(validity);
            //            if (System.currentTimeMillis() - time <= 60000 * 5) {//check 5 min. validity
            if (System.currentTimeMillis() - time <= 86400000 * 7) {//check 7 day validity
                User currentUser = new User();
                currentUser.setFirstName("Dirsat");
                modelAndView.addObject("user", currentUser);
                modelAndView.addObject("order", shipmentService.orderDetails(token,orderId));
                modelAndView.setViewName("shipment/details");
                return modelAndView;
            } else {
                return modelAndView;
            }
        } else {
            return modelAndView;
        }
    }

    @PostMapping(value = "/order-delevary-confirm")
    public ModelAndView orderDelevaryConfirm(@RequestBody Map<String, Object> order) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(order);
        System.out.println(order.get("orderList"));
        shipmentService.saveRecive(order);
        modelAndView.setViewName("redirect:/all-shipment");
        return modelAndView;
    }
}
