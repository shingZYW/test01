package com.scut.leaflet.service;

import com.scut.leaflet.dataobject.Forwarder;
import com.scut.leaflet.dataobject.Leaflet;

import java.util.List;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 10:20
 */
public interface ForwarderService {
    Forwarder findone(String openId);

    List<Forwarder> findUpAll();

    String forwarder(String leafletId,String openId,String name);
    //第一次通过DTO创建商户表

    //创建Forwarder
    Forwarder create(Forwarder forwarder);

    //增加优惠券


    //添加钱同时减少传单的钱


}
