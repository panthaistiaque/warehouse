package com.ihit.warehouse.mscproject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 9/7/2021.
 */
@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Integer> {
    List findByIsActive(boolean isActive);
}
