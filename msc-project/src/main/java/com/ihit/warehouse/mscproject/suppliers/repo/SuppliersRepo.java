package com.ihit.warehouse.mscproject.suppliers.repo;

import com.ihit.warehouse.mscproject.suppliers.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2/27/2021.
 */
@Repository
public interface SuppliersRepo extends JpaRepository<Suppliers, Integer> {
}
