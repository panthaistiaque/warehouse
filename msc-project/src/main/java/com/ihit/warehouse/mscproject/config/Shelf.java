package com.ihit.warehouse.mscproject.config;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by User on 8/27/2021.
 */
@Data
@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer slotNumber;
    @Transient
    private Integer usedSlot;
    @Transient
    private List usedSlotDtl;
    @Column(length = 10)
    private String shortName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id",referencedColumnName = "id")
    List<Slot> slots;
}
