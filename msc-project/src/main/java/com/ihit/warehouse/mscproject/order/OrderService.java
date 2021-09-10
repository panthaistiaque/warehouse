package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 9/10/2021.
 */
@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    public Order save(Order order){
        if(order.getId()==null){
            order.setStatus(Status.INITIATED);
            order.setActive(true);
        }
        return orderRepo.save(order);
    }

    public List getAll() {
        return orderRepo.findAll();
    }

    public Order getOne(Integer id) {
        return orderRepo.findById(id).get();
    }
}
