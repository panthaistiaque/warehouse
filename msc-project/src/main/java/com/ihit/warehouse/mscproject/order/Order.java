package com.ihit.warehouse.mscproject.order;

import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date requestDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date requiredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date forwardDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date approvedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date sendDate;

    @Column(name = "Status", columnDefinition = "enum('Initiated','Froward','Receive','Approved')")
    private String status;

    private boolean active;

    @ElementCollection
    private List<OrderDtl> dtl = new ArrayList<>();

}
