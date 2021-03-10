package com.ihit.warehouse.mscproject.shipment.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 3/10/2021.
 */
@Repository
public class ShipmentRepo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public  ShipmentRepo(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
    }

    public int saveShipment(Map<String, Object> shipment) {
        String insertSql = "INSERT INTO  shipment_master ( suppliers_id, remarks, requested_date) VALUES ( :suppliers_id, :remarks, :requested_date) ";
        Map<String, Object> map = new HashMap<>();

        map.put("suppliers_id", shipment.get("supplier"));
        map.put("remarks", shipment.get("rmarks"));
        map.put("requested_date", shipment.get("requested_date"));
        System.out.println(map);
        return namedParameterJdbcTemplate.update(insertSql, map);
    }
}
