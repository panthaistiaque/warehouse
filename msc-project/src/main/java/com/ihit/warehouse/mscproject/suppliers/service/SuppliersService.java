package com.ihit.warehouse.mscproject.suppliers.service;

import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import com.ihit.warehouse.mscproject.suppliers.repo.SuppliersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2/27/2021.
 */
@Repository
public class SuppliersService {
    @Autowired
    SuppliersRepo suppliersRepo;


    public Suppliers save(Suppliers suppliers) {
        return suppliersRepo.save(suppliers);
    }
    public List<Suppliers> findAll(){
        return suppliersRepo.findAll();
    }
    public Suppliers findById(Integer id){
        return suppliersRepo.findById(id).get();
    }
}
