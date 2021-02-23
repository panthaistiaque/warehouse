package com.ihit.warehouse.mscproject.auth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by User on 2/22/2021.
 */
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "role_name", unique = true, nullable = false, length = 20)
    private String roleName;
}
