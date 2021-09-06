package com.ihit.warehouse.mscproject.product;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 9/6/2021.
 */
@Data
@Entity
@Table(name = "brand")
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATETIME")
    private Date createdOn;
    private Boolean isActive;
}
