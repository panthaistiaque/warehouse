package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.product.ProductModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 10/22/2021.
 */
@Data
@Entity
@Table(name = "stock")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private ProductModel product;
    private Integer qty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date lastUpdateOn;
}
