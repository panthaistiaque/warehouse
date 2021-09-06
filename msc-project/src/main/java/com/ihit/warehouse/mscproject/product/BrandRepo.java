package com.ihit.warehouse.mscproject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 9/6/2021.
 */
@Repository
public interface BrandRepo extends JpaRepository<BrandModel,Integer> {
}
