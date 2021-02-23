package com.ihit.warehouse.mscproject.auth.model;

/**
 * Created by user on 1/22/2021.
 */

import lombok.Data;

import javax.persistence.*;
@Data
//@Entity
//@Table(name = "user")
public class UserEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
//    @Column(unique = true)
    private String email;
    private String password;

    public UserEntity() {
    }
    //getter and setter
}