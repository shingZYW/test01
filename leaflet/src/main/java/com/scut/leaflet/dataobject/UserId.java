package com.scut.leaflet.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ass we can!
 * created by shing
 * 2019-03-28 21:22
 */
@Data
@Entity
public class UserId {

    @Id
    private String openId;

    private String uuid;
}
