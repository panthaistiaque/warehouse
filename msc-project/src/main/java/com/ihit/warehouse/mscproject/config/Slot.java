package com.ihit.warehouse.mscproject.config;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by User on 8/27/2021.
 */
@Data
@Entity
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(length = 10)
    private String shortName;

//    @OneToMany
//    private Shelf shelf;

}
