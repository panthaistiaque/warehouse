package com.ihit.warehouse.mscproject.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 9/10/2021.
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
