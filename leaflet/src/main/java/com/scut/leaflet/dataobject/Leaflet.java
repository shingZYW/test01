package com.scut.leaflet.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * ass we can!
 * created by shing
 * 传单表
 * 2019-03-26 20:09
 */
@Entity
@Data
public class Leaflet {

    @Id
    private String leafletId;

    private String shopId;

    private String shopAddr;

    private String productIcon1;

    private String productIcon2;

    private String productAddr1;

    private String ProductAddr2;

    private String couponId;
    /**
     * 优惠券说明
     */

    private String coupon;

    private int count;

    private BigDecimal leafletPrice;

    public Leaflet() {
    }
}
