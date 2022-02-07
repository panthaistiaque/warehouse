package com.ihit.warehouse.mscproject.delivery;

import com.ihit.warehouse.mscproject.product.ProductModel;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by user on 11/12/2021.
 */
@Data
@Embeddable
public class DeliveryDtl {
    private Integer deliveredQty;

    @ManyToOne
    private ProductModel product;

    private String deliveryMap;
}
