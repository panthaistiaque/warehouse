package com.ihit.warehouse.mscproject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 9/7/2021.
 */
@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel,Integer > {
}
