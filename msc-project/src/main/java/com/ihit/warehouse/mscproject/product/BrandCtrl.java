package com.ihit.warehouse.mscproject.product;

import com.ihit.warehouse.mscproject.config.AppProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 9/6/2021.
 */
@Controller
public class BrandCtrl extends AppProperty {
    @Autowired
    BrandService brandService;

    @GetMapping(value = "/brand_list")
    private ModelAndView getBrandList(ModelAndView modelAndView){
        modelAndView.addObject("list",brandService.getAll());
        modelAndView.setViewName("product/brand_list");
        return modelAndView;
    }
    @GetMapping(value = "/brand_form")
    private ModelAndView getBrand(ModelAndView modelAndView){
        modelAndView.addObject("brand",new BrandModel());
        modelAndView.setViewName("product/brand_entry_form");
        return modelAndView;
    }
    @PostMapping(value = "/brand_deactive/{id}")
    private ModelAndView deactiveBrandList(ModelAndView modelAndView,@PathVariable("id") Integer id){
        brandService.deactive(id);
        modelAndView.setViewName("redirect:/brand_list");
        return modelAndView;
    }
    @PostMapping(value = "/saveBrand")
    private ModelAndView saveBrand(ModelAndView modelAndView, BrandModel brandModel){
        brandService.save(brandModel);
        modelAndView.setViewName("redirect:/brand_list");
        return modelAndView;
    }

    @GetMapping(value = "/get-brand/{id}")
    private ModelAndView getBrand(ModelAndView modelAndView,@PathVariable("id") Integer id){
        modelAndView.addObject("brand",brandService.find(id));
        modelAndView.setViewName("product/brand_entry_form");
        return modelAndView;
    }
}
