package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.product.ProductModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by user on 10/23/2021.
 */
@Repository
public class AllottedSlotCustomRepo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AllottedSlotCustomRepo(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Integer findFreeSlot(ProductModel product) {
        String sql = "SELECT id FROM slot WHERE shelf_id NOT IN ( SELECT shelf_id FROM slot_allotted sa INNER JOIN slot s ON s.id =sa.slot_id WHERE sa.is_active = TRUE AND is_full = FALSE AND product_id != ?) order by id limit 1";
         Map<String, Object> map = jdbcTemplate.queryForMap(sql, product.getId());
        return (Integer) map.get("id");
    }
}
