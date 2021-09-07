package com.ihit.warehouse.mscproject.product;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 9/7/2021.
 */
@Data
@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private CategoryModel category;

    @ManyToOne
    private BrandModel brand;

    @Column(columnDefinition = "DATETIME")
    private Date createdOn;

    private Boolean isActive;
}
