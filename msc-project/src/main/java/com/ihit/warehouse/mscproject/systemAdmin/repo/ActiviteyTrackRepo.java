package com.ihit.warehouse.mscproject.systemAdmin.repo;

import com.ihit.warehouse.mscproject.systemAdmin.DataBind.ActiviteyTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 8/15/2021.
 */
@Repository
public interface ActiviteyTrackRepo extends JpaRepository<ActiviteyTrack, Integer> {
}
