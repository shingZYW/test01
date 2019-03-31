package com.scut.leaflet.service.Impl;

import com.scut.leaflet.controller.key;
import com.scut.leaflet.dataobject.ShopInfo;
import com.scut.leaflet.dataobject.UserId;
import com.scut.leaflet.dto.UploadDTO;
import com.scut.leaflet.exception.ResultEnum;
import com.scut.leaflet.exception.shopInfoException;
import com.scut.leaflet.repository.ShopInfoRepository;
import com.scut.leaflet.repository.UserIdRepository;
import com.scut.leaflet.service.LeafletService;
import com.scut.leaflet.service.ShopInfoService;
import com.scut.leaflet.service.UserIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

/**
 * ass we can!
 * created by shing
 * 2019-03-28 21:45
 */
@Slf4j
@Service
public class ShopInfoServiceImpl implements ShopInfoService {
    @Autowired
    private  ShopInfoRepository shopInfoRepository;

    @Autowired
     private  UserIdRepository userIdRepository;
    @Autowired
     private  LeafletService leafletService;

     @Autowired
     private UserIdService userIdService;


    @Override
    @Transactional
    public String create1(UploadDTO uploadDTO, MultipartFile pc1,MultipartFile pc2) throws IOException {
        ShopInfo shopInfo = new ShopInfo();

        //生成openId，优惠券Id
        System.out.println("开始创建商户表");
        if(true) {
            UserId userId = new UserId();
            //将openId与uuid成对保存
            String s = key.unique();
            userId.setUuid(s);
            userId.setOpenId(uploadDTO.getOpenId());
            System.out.println("开始openid表");
            userIdRepository.save(userId);
            //保存新的商户表
            shopInfo.setShopName(uploadDTO.getShopName());
            shopInfo.setShopId(s);
            shopInfo.setShopAddr(uploadDTO.getShopAddr());
            shopInfo.setShopNum(uploadDTO.getShopNum());
            shopInfo.setCouponId(key.unique());
            System.out.println("开始创建图片表");
            shopInfoRepository.save(shopInfo);
            //建立传单表储存图片,建立优惠券表

            leafletService.create1(uploadDTO,pc1,pc2,shopInfo);
    }else{
            ShopInfo shopInfo1 = new ShopInfo();
            //从数据库获得shopinfo
            userIdService.findById(uploadDTO.getOpenId()).getUuid();
            leafletService.create1(uploadDTO,pc1,pc2,shopInfoRepository.findOneByShopId(userIdService.findById(uploadDTO.getOpenId()).getUuid()));
            return  "555";}

            return "888";



        }

    @Override
    public String test() {
        return "这是为什么";
    }
     /*   else{
            ShopInfo shopInfo1 = new ShopInfo();
            //从数据库获得shopinfo
            userIdService.findById(uploadDTO.getOpenId()).getUuid();
           leafletService.create1(uploadDTO,pc1,pc2,shopInfoRepository.findOneByShopId(userIdService.findById(uploadDTO.getOpenId()).getUuid()));
           return  "555";


        }*/



    //}
}
