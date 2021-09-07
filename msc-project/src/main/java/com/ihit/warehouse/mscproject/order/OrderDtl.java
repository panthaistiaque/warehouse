package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.product.ProductModel;
import com.ihit.warehouse.mscproject.product.UnitModel;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by user on 9/7/2021.
 */
@Data
@Embeddable
public class OrderDtl {
    private Integer orderQty;

    @ManyToOne
    private ProductModel product;

    @ManyToOne
    private UnitModel unit;

}
