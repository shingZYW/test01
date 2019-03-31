package com.scut.leaflet.dataobject;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 17:55
 */
@Data
@Entity
public class Coupon {

    @Id
    private String couponId;

    private String coupon;

    private String openId;

    private Date createTime;

    private Date updateTime;

    public Coupon() {
    }
}
