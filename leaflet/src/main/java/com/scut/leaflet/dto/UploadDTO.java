package com.scut.leaflet.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 18:37
 */
@Data
public class UploadDTO {

    private String openId;

    private String shopAddr;

    private String shopName;

    private String shopNum;

    private String coupon;

    private BigDecimal leafletPrice;

    private String productIcon1;

    private String productIcon2;


}
