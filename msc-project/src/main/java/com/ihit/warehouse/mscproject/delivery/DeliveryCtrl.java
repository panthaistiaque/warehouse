package com.ihit.warehouse.mscproject.delivery;

import com.ihit.warehouse.mscproject.config.AppProperty;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * Created by user on 11/8/2021.
 */
@Controller
public class DeliveryCtrl extends AppProperty {
    @Autowired
    DeliveryService deliveryService;

    @GetMapping(value = "/delivery_form")
    private ModelAndView getBrandList(ModelAndView modelAndView){
        modelAndView.setViewName("delivery/delivery_form");
        return modelAndView;
    }
    @PostMapping(value = "/saveDelivery")
    private ModelAndView saveOrder(ModelAndView modelAndView, @RequestBody Delivery delivery, RedirectAttributes redirect) {
        deliveryService.saveDelivery(delivery);
        modelAndView.setViewName("redirect:/delivery_list");
        return modelAndView;
    }
    @GetMapping(value = "/delivery_list")
    public ModelAndView getReceiveList(ModelAndView modelAndView){
        modelAndView.addObject("list", deliveryService.getAll());
        modelAndView.setViewName("delivery/delivery_list");
        return modelAndView;
    }
    @ResponseBody
    @PostMapping(value = "/delivery-details/{id}")
    private Delivery deliveryDetail(@PathVariable("id") Integer id) {
        return deliveryService.getById(id);
    }

    @PostMapping(value = "/delivery-complete/{id}")
    private ModelAndView deliveryComplete(ModelAndView modelAndView,@PathVariable("id") Integer id) {
        Delivery delivery = deliveryService.getById(id);
        delivery.setStatus(Status.DELIVERY_STATUS.COMPLETE);
        delivery.setCompleteDate(new Date());
        deliveryService.saveDelivery(delivery);
        modelAndView.setViewName("redirect:/brand_list");
        return modelAndView;
    }
}
