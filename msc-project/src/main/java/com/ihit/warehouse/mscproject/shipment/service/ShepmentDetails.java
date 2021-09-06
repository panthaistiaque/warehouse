package com.ihit.warehouse.mscproject.shipment.service;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by user on 9/6/2021.
 */
@Data
@Embeddable
public class ShepmentDetails {
    private String name;
    private String size;
    private Integer qty;
    private boolean active;
}
