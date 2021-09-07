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
public class ProductCtrl  extends AppProperty {
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "new_product")
    private ModelAndView newProduct(ModelAndView modelAndView){
        modelAndView.addObject("product",new ProductModel());
        modelAndView.addObject("brandList",brandService.getAllActiveBrand(true));
        modelAndView.addObject("categoryList",categoryService.getAllActiveCategory(true));
        modelAndView.setViewName("product/product_entry_form");
        return modelAndView;
    }

    @GetMapping(value = "product_list")
    private ModelAndView productList(ModelAndView modelAndView){
        modelAndView.addObject("productList",productService.gelAll());
        modelAndView.setViewName("product/product_list");
        return modelAndView;
    }

    @PostMapping(value = "/saveProduct")
    private ModelAndView saveProduct(ModelAndView modelAndView, ProductModel productModel){
        productService.save(productModel);
        modelAndView.setViewName("redirect:/product_list");
        return modelAndView;
    }

    @GetMapping(value = "/get-product/{id}")
    private ModelAndView getProduct(ModelAndView modelAndView,@PathVariable("id") Integer id){
        modelAndView.addObject("product",productService.findOne(id));
        modelAndView.addObject("brandList",brandService.getAll());
        modelAndView.addObject("categoryList",categoryService.getAll());
        modelAndView.setViewName("product/product_entry_form");
        return modelAndView;
    }

    @PostMapping(value = "/product_deactive/{id}")
    private ModelAndView deactiveProduct(ModelAndView modelAndView,@PathVariable("id") Integer id){
        productService.deactive(id);
        modelAndView.setViewName("redirect:/product_list");
        return modelAndView;
    }

}
