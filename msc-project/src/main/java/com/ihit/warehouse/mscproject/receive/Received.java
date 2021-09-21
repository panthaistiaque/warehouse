package com.ihit.warehouse.mscproject.receive;

import com.ihit.warehouse.mscproject.order.Order;
import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 9/20/2021.
 */
@Data
@Entity
@Table(name = "receive")
public class Received {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Suppliers suppliers;
    @OneToOne
    private Order order;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date receiveDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date approvedDate;

    @Column(name = "Status", columnDefinition = "enum('Initiated','Cancel','Approved')")
    private String status;

    @ElementCollection
    private List<ReceivedDtl> dtl = new ArrayList<>();
//    pe
}
