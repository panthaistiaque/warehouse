package com.ihit.warehouse.mscproject.receive;

import com.ihit.warehouse.mscproject.product.ProductModel;
import com.ihit.warehouse.mscproject.product.UnitModel;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by User on 9/21/2021.
 */
@Data
@Embeddable
public class ReceivedDtl {
    private Integer orderQty;
    private Integer approveQty;

    @ManyToOne
    private ProductModel product;

    @ManyToOne
    private UnitModel unit;
}
