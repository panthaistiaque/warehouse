package com.ihit.warehouse.mscproject.receive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 9/22/2021.
 */
@Repository
public interface ReceivedRepo extends JpaRepository<Received, Integer> {
}
