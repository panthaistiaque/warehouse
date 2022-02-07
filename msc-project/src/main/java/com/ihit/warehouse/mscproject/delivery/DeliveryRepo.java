package com.ihit.warehouse.mscproject.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 11/12/2021.
 */
@Repository
public interface DeliveryRepo  extends JpaRepository<Delivery, Integer> {
}
