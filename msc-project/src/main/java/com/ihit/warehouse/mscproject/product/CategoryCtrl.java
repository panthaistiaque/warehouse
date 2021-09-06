package com.ihit.warehouse.mscproject.product;

import com.ihit.warehouse.mscproject.config.AppProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 9/7/2021.
 */
@Controller
public class CategoryCtrl extends AppProperty {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/category_list")
    public ModelAndView getCategoryList(ModelAndView modelAndView) {
        modelAndView.addObject("list", categoryService.getAll());
        modelAndView.setViewName("product/category_list");
        return modelAndView;
    }
    @GetMapping(value = "/category_form")
    private ModelAndView getCategory(ModelAndView modelAndView){
        modelAndView.addObject("category",new CategoryModel());
        modelAndView.setViewName("product/category_entry_form");
        return modelAndView;
    }
    @PostMapping(value = "/category_deactive/{id}")
    private ModelAndView deactivecategory(ModelAndView modelAndView,@PathVariable("id") Integer id){
        categoryService.deactive(id);
        modelAndView.setViewName("redirect:/category_list");
        return modelAndView;
    }
    @PostMapping(value = "/saveCategory")
    private ModelAndView saveCategory(ModelAndView modelAndView, CategoryModel categoryModel){
        categoryService.save(categoryModel);
        modelAndView.setViewName("redirect:/category_list");
        return modelAndView;
    }

    @GetMapping(value = "/get-category/{id}")
    private ModelAndView getCategory(ModelAndView modelAndView,@PathVariable("id") Integer id){
        modelAndView.addObject("category",categoryService.findOne(id));
        modelAndView.setViewName("product/category_entry_form");
        return modelAndView;
    }
}
