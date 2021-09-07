package com.ihit.warehouse.mscproject.product;

import com.ihit.warehouse.mscproject.config.AppProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 9/7/2021.
 */
@Controller
public class UnitCtrl extends AppProperty {
    @Autowired
    UnitService unitService;

    @GetMapping(value = "/unit_list")
    private ModelAndView getUnitList(ModelAndView modelAndView){
        modelAndView.addObject("list",unitService.getAll());
        modelAndView.setViewName("product/unit_list");
        return modelAndView;
    }
    @GetMapping(value = "/unit_form")
    private ModelAndView getUnit(ModelAndView modelAndView){
        modelAndView.addObject("unit",new BrandModel());
        modelAndView.setViewName("product/unit_entry_form");
        return modelAndView;
    }
    @PostMapping(value = "/unit_deactive/{id}")
    private ModelAndView deactiveUnitList(ModelAndView modelAndView,@PathVariable("id") Integer id){
        unitService.deactive(id);
        modelAndView.setViewName("redirect:/unit_list");
        return modelAndView;
    }
    @PostMapping(value = "/saveUnit")
    private ModelAndView saveUnit(ModelAndView modelAndView, UnitModel unitModel){
        unitService.save(unitModel);
        modelAndView.setViewName("redirect:/unit_list");
        return modelAndView;
    }

    @GetMapping(value = "/get-unit/{id}")
    private ModelAndView getBrand(ModelAndView modelAndView,@PathVariable("id") Integer id){
        modelAndView.addObject("unit",unitService.findOne(id));
        modelAndView.setViewName("product/unit_entry_form");
        return modelAndView;
    }
}
