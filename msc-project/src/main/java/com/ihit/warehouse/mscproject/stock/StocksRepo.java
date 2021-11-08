package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 10/22/2021.
 */
@Repository
public interface StocksRepo extends JpaRepository<Stocks, Integer> {
    Stocks findByProduct(ProductModel product);
    List findAllByOrderByProductCategoryNameAscProductNameAsc();
}
