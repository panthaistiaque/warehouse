package com.ihit.warehouse.mscproject.shipment.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
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

    public Integer saveShipmentMaster(Map<String, Object> shipment) {
        String insertSql = "INSERT INTO  shipment_master ( suppliers_id, remarks, requested_date) VALUES ( :suppliers_id, :remarks, :requested_date) ";
//        Map<String, Object> map = new HashMap<>();
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("suppliers_id", shipment.get("supplier"));
        map.addValue("remarks", shipment.get("rmarks"));
        map.addValue("requested_date", shipment.get("requested_date"));
        System.out.println(map);
        KeyHolder holder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertSql, map,holder, new String[]{"id"});

        return  holder.getKey().intValue();
    }
    public int[] saveShipmentDetails(List<Map<String, Object>> shipment) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(shipment.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(
                "INSERT INTO shipment_details(shipment_master_id, type, name, size, qty)  VALUES (:orderMasterId, :type, :name, :size, :qty)", batch);
        return updateCounts;
    }
}
