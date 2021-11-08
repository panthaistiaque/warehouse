package com.ihit.warehouse.mscproject.delivery;

import com.ihit.warehouse.mscproject.config.AppProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 11/8/2021.
 */
@Controller
public class DeliveryCtrl extends AppProperty {
    @GetMapping(value = "/delivery_form")
    private ModelAndView getBrandList(ModelAndView modelAndView){
        modelAndView.setViewName("delivery/delivery_form");
        return modelAndView;
    }
}
