package com.ihit.warehouse.mscproject.suppliers.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by User on 2/27/2021.
 */
@Data
@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column( nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 20)
    private String type;
    private String address;
    @Column(nullable = false, length = 30)
    private String email;
    @Column(nullable = false, length = 30)
    private String contactPersonName;
    @Column(nullable = false, length = 11)
    private String contactPersonPhone;
    private String remarks;
}
