package com.scut.leaflet.repository;

import com.scut.leaflet.dataobject.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 10:08
 */
public interface ShopInfoRepository extends JpaRepository<ShopInfo,String> {
    ShopInfo findOneByShopId(String openId);
}
