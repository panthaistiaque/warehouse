package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 9/7/2021.
 */
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Suppliers suppliers;
    private String note;
    @Column(columnDefinition = "DATETIME")
    private Date requestDate;
    @Column(columnDefinition = "DATETIME")
    private Date requiredDate;

    @Column(name = "Status", columnDefinition = "enum('Initiated','Froward','Send','Approved')")
    private String Status;

    private boolean active;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<OrderDtl> dtl = new ArrayList<>();

}
