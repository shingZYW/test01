package com.scut.leaflet.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ass we can!
 * created by shing
 * 商家表
 * 2019-03-26 16:54
 */
@Entity
@Data
public class ShopInfo {
    @Id
    /**
     * 店家的openId
     */
    private String shopId;


    private String shopName;

    private String shopAddr;

    private String shopNum;

    private String couponId;

    public ShopInfo() {
    }
}
