package com.ihit.warehouse.mscproject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 9/7/2021.
 */
@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List getAll() {
        return categoryRepo.findAll();
    }

    public void deactive(Integer id) {
        CategoryModel model =  categoryRepo.getOne(id);
        model.setIsActive(!model.getIsActive());
        model.setCreatedOn(new Date());
        categoryRepo.save(model);
    }
    public void save(CategoryModel categoryModel) {
        categoryModel.setIsActive(true);
        categoryModel.setCreatedOn(new Date());
        categoryRepo.save(categoryModel);
    }

    public CategoryModel findOne(Integer id) {
        return categoryRepo.getOne(id);
    }
}
