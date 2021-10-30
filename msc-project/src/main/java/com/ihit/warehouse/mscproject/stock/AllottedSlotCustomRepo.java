package com.ihit.warehouse.mscproject.stock;

import com.ihit.warehouse.mscproject.config.Slot;
import com.ihit.warehouse.mscproject.product.ProductModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
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
    public List<Slot> findFreeSlot(ProductModel product) {
        String sql = "SELECT id FROM slot WHERE shelf_id NOT IN ( SELECT shelf_id FROM slot_allotted sa INNER JOIN slot s ON s.id =sa.slot_id WHERE sa.is_active = TRUE AND is_full = FALSE AND product_id != ?) order by id limit 1";
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT s.* FROM slot s LEFT JOIN slot_allotted sa ON sa.slot_id = s.id ");
        sb.append(" WHERE s.shelf_id NOT IN ( SELECT DISTINCT s.shelf_id  ");
        sb.append(" FROM slot s INNER JOIN slot_allotted sa ON sa.slot_id = s.id  ");
        sb.append(" WHERE sa.product_id NOT IN  ("+product.getId()+") AND sa.is_active = TRUE) ");
        sb.append(" AND sa.qty IS NULL ");
        List<Slot> list = jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper(Slot.class));
        return list;
    }

    public List<SlotAllotted> usedSlotByShelf(Integer id){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT sa.* FROM slot_allotted sa  ");
        sb.append(" INNER JOIN slot s ON s.id = sa.slot_id ");
        sb.append(" WHERE s.shelf_id = "+ id + "");
        List<SlotAllotted> list = jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper(SlotAllotted.class));
        return list;
    }
}
