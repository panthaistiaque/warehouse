package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 10/22/2021.
 */
@Repository
public interface SlotAllottedRepo extends JpaRepository<SlotAllotted, Integer> {
    SlotAllotted findByProductAndIsFull(ProductModel product,Boolean isFull);
}
