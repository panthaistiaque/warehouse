package com.ihit.warehouse.mscproject.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 8/31/2021.
 */
@Repository
public interface shelfRepo extends JpaRepository<Shelf, Integer> {
}
