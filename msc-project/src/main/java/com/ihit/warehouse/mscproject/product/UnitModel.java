package com.ihit.warehouse.mscproject.product;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 9/7/2021.
 */
@Data
@Entity
@Table(name = "unit")
public class UnitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATETIME")
    private Date createdOn;
    private Boolean isActive;
}
