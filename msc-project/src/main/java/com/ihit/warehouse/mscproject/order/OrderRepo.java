package com.ihit.warehouse.mscproject.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 9/10/2021.
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    Order findByIdAndSuppliersId(Integer id, Integer suppliersid);
    List findAllBySuppliersIdAndStatusIn(Integer id,List<String> status);
}
