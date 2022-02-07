package com.ihit.warehouse.mscproject.delivery;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 11/12/2021.
 */
@Data
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date deliveryDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date completeDate;


    @Column(name = "Status", columnDefinition = "enum('Initiated','Competed')")
    private String status;

    private boolean active;

    @ElementCollection
    private List<DeliveryDtl> dtl = new ArrayList<>();
}
