package com.ihit.warehouse.mscproject.systemAdmin.Service;

import com.ihit.warehouse.mscproject.systemAdmin.DataBind.ActiviteyTrack;
import com.ihit.warehouse.mscproject.systemAdmin.repo.ActiviteyTrackRepo;
import com.ihit.warehouse.mscproject.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 8/15/2021.
 */
@Service
public class ActiviteyTrackService {
    @Autowired
    ActiviteyTrackRepo  trackRepo;
    public ActiviteyTrack save( ActiviteyTrack activiteyTrack){
        if (activiteyTrack.getCode().intValue()==404){
            activiteyTrack.setMessage(Status.Notification.ERROR_404);
            activiteyTrack.setType(Status.NOTIFICATION_TYPE.SYS_NOTIFICATION);
        } else if (activiteyTrack.getCode().intValue()==403){
            activiteyTrack.setMessage(Status.Notification.ERROR_403);
            activiteyTrack.setType(Status.NOTIFICATION_TYPE.SYS_NOTIFICATION);
        }else if (activiteyTrack.getCode().intValue()==500){
            activiteyTrack.setMessage(Status.Notification.ERROR_500);
            activiteyTrack.setType(Status.NOTIFICATION_TYPE.SYS_NOTIFICATION);
        }
        return trackRepo.save(activiteyTrack);
    }
}
