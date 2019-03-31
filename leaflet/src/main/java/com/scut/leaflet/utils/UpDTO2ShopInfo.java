package com.scut.leaflet.utils;

import com.scut.leaflet.dataobject.ShopInfo;
import com.scut.leaflet.dto.UploadDTO;
import com.scut.leaflet.repository.ShopInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 21:21
 */
public class UpDTO2ShopInfo {
    @Autowired
    ShopInfoRepository shopInfoRepository;
    @Transactional
    public void updto2shopinfo(UploadDTO uploadDTO){

        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopName(uploadDTO.getShopName());
        shopInfo.setShopId(uploadDTO.getOpenId());
        shopInfo.setShopAddr(uploadDTO.getShopAddr());
        shopInfo.setShopNum(uploadDTO.getShopNum());
        shopInfo.setCouponId(uploadDTO.getCoupon());
        shopInfoRepository.save(shopInfo);

    }
}
