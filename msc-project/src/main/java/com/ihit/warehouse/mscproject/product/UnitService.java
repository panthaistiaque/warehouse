package com.ihit.warehouse.mscproject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 9/7/2021.
 */
@Service
public class UnitService {
    @Autowired
    UnitRepo unitRepo;

    public List getAll() {
        return unitRepo.findAll();
    }
    public List getAllActiveUnit(boolean isActive) {
        return unitRepo.findByIsActive(isActive);
    }

    public void deactive(Integer id) {
        UnitModel model =  unitRepo.getOne(id);
        model.setIsActive(!model.getIsActive());
        model.setCreatedOn(new Date());
        unitRepo.save(model);
    }
    public void save(UnitModel unitModel) {
        unitModel.setIsActive(true);
        unitModel.setCreatedOn(new Date());
        unitRepo.save(unitModel);
    }

    public UnitModel findOne(Integer id) {
        return unitRepo.getOne(id);
    }
}
