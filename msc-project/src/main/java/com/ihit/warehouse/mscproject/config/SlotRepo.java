package com.ihit.warehouse.mscproject.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 10/23/2021.
 */
@Repository
public interface SlotRepo extends JpaRepository<Slot, Integer> {
}
