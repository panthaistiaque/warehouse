package com.ihit.warehouse.mscproject.shipment;

import com.ihit.warehouse.mscproject.shipment.service.ShepmentDetails;
import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 9/6/2021.
 */
@Data
@Entity
@Table(name = "shipment")
public class ShipmentMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Suppliers suppliers;

    private String remarks;

    @Column(columnDefinition = "DATETIME")
    private String requestedDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ShepmentDetails> dtl = new ArrayList<>();

    @Column(name = "Status", columnDefinition = "enum('Initiated','Froward','Send','Approved')")
    private String Status;

    private boolean active;

}
