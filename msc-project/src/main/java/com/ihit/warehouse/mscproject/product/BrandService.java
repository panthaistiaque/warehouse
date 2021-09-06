package com.ihit.warehouse.mscproject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 9/6/2021.
 */
@Service
public class BrandService {
    @Autowired
    private BrandRepo brandRepo;

    public List getAll(){
        return brandRepo.findAll();
    }

    public void deactive(Integer id) {
        BrandModel model =  brandRepo.getOne(id);
        model.setIsActive(!model.getIsActive());
        model.setCreatedOn(new Date());
        brandRepo.save(model);
    }

    public void save(BrandModel brandModel) {
        brandModel.setIsActive(true);
        brandModel.setCreatedOn(new Date());
        brandRepo.save(brandModel);
    }

    public BrandModel find(Integer id) {
        return brandRepo.getOne(id);
    }
}
