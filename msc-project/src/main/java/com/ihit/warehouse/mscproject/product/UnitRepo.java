package com.ihit.warehouse.mscproject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by User on 9/7/2021.
 */
@Repository
public interface UnitRepo extends JpaRepository<UnitModel, Integer> {
}
