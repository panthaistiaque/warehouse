package com.ihit.warehouse.mscproject.systemAdmin.DataBind;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by User on 8/15/2021.
 */
@Data
@Entity
@Table(name = "activity_track")
public class ActiviteyTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer code;
    private String url;
    private String message;
    private Integer user;
    @Column(columnDefinition = "DATETIME")
    private String createdOn;
    @Column(name="type", columnDefinition="enum('NOTI','SYS_NOTI')")
    private String type;
    private String session;


}
