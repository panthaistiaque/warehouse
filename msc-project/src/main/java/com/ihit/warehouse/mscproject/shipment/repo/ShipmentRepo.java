package com.ihit.warehouse.mscproject.shipment.repo;

import com.ihit.warehouse.mscproject.util.Status;
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

    public ShipmentRepo(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
        namedParameterJdbcTemplate.update(insertSql, map, holder, new String[]{"id"});

        return holder.getKey().intValue();
    }

    public int[] saveShipmentDetails(List<Map<String, Object>> shipment) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(shipment.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(
                "INSERT INTO shipment_details(shipment_master_id, type, name, size, qty)  VALUES (:orderMasterId, :type, :name, :size, :qty)", batch);
        return updateCounts;
    }

    public List<Map<String, Object>> getAllOrders() {
        String sql = "SELECT md5(s.id) sid, s.*,su.* FROM shipment_master s inner join suppliers su on su.id = s.suppliers_id where active='1'";
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> findOneById(Integer id) {
        String sql = "SELECT s.*  FROM shipment_master s  where active='1' and id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public List<Map<String, Object>> findOneOrderDetailsById(Integer id) {
        String sql = "SELECT * FROM shipment_details s where active = 1 and shipment_master_id=?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public void deleteOrders(Integer id) {
        String sql = "update shipment_master set active = 0 where id= ?";
        jdbcTemplate.update(sql, id);
    }

    public void orderFroward(Integer id) {
        String sql = "update shipment_master set status=? where id= ?";
        jdbcTemplate.update(sql, Status.FROWARD, id);
    }

    public Map<String, Object> findOneOrderById(String token, String orderId) {
        String sql = "SELECT s.*  FROM shipment_master s  where active='1' and md5(id) = ? and md5(suppliers_id) = ?";
        return jdbcTemplate.queryForMap(sql, orderId,token);
    }
}
