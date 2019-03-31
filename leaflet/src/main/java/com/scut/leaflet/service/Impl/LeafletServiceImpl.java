package com.scut.leaflet.service.Impl;

import com.scut.leaflet.controller.key;
import com.scut.leaflet.dataobject.Coupon;
import com.scut.leaflet.dataobject.Leaflet;
import com.scut.leaflet.dataobject.ShopInfo;
import com.scut.leaflet.dataobject.UserId;
import com.scut.leaflet.dto.UploadDTO;
import com.scut.leaflet.repository.CouponRepository;
import com.scut.leaflet.repository.LeafletRepository;
import com.scut.leaflet.repository.UserIdRepository;
import com.scut.leaflet.service.LeafletService;
import com.scut.leaflet.service.UserIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.scut.leaflet.utils.picUtil.singleFileUpload;

/**
 * ass we can!
 * created by shing
 * 2019-03-28 22:27
 */
@Service
@Slf4j
public class LeafletServiceImpl implements LeafletService {

    @Autowired
    UserIdService userIdService;


    @Autowired
    LeafletRepository leafletRepository;


    @Autowired
    CouponRepository couponRepository;
    @Override
    public void create1(UploadDTO uploadDTO, MultipartFile pc1, MultipartFile pc2,ShopInfo shopInfo) throws IOException {


        Leaflet leaflet = new Leaflet();
         //从DTO中获得基础信息
        //生成订单唯一的id，通过OpenId可以查询传单Id，图片地址
        leaflet.setLeafletId(key.unique());
        leaflet.setLeafletPrice(uploadDTO.getLeafletPrice());
        leaflet.setCount(0);;
        leaflet.setProductIcon1(uploadDTO.getProductIcon1());
        leaflet.setProductIcon1(uploadDTO.getProductIcon2());
        leaflet.setShopId(userIdService.findById(uploadDTO.getOpenId()).getOpenId());
        leaflet.setProductAddr1(singleFileUpload(pc1,shopInfo.getShopId()));
        leaflet.setProductAddr2(singleFileUpload(pc2,shopInfo.getShopId()));
        leaflet.setCount(0);
        leaflet.setCoupon(uploadDTO.getCoupon());
        leaflet.setCouponId(shopInfo.getCouponId());
        //妈耶
        leafletRepository.save(leaflet);
         //建立券的表OpenId
        /**
         * //存入数据库
         */
        Coupon coupon= new Coupon();
        coupon.setCoupon(uploadDTO.getCoupon());
        coupon.setCouponId(shopInfo.getCouponId());
        coupon.setOpenId(shopInfo.getShopId());
        couponRepository.save(coupon);







    }
}
