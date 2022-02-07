package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.config.Slot;
import com.ihit.warehouse.mscproject.product.ProductModel;
import com.ihit.warehouse.mscproject.product.UnitModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 10/22/2021.
 */
@Data
@Entity
@Table(name = "slot_allotted")
public class SlotAllotted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private ProductModel product;
    @ManyToOne
    private UnitModel unit;
    @ManyToOne
    private Stocks stock;
    @ManyToOne
    private Slot slot;
    private Integer qty;
    private boolean isFull;
    private boolean isActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date lastUpdateOn;
    @Transient
    private Integer slotId;

}
