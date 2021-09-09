package com.ihit.warehouse.mscproject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 9/7/2021.
 */
@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public ProductModel save(ProductModel productModel) {
        productModel.setIsActive(true);
        productModel.setCreatedOn(new Date());
        return productRepo.save(productModel);
    }

    public List gelAll(){
        return productRepo.findAll();
    }

    public ProductModel findOne(Integer id) {
        return productRepo.getOne(id);
    }

    public ProductModel deactive(Integer id) {
        ProductModel productModel = findOne(id);
        productModel.setIsActive(!productModel.getIsActive());
        productModel.setCreatedOn(new Date());
        return productRepo.save(productModel);
    }

    public List getAllActiveProduct(boolean isActive) {
        return productRepo.findByIsActive(isActive);
    }
}
