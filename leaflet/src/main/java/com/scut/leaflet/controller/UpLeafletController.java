package com.scut.leaflet.controller;

import com.scut.leaflet.dataobject.Forwarder;
import com.scut.leaflet.dataobject.ShopInfo;
import com.scut.leaflet.dataobject.UserId;
import com.scut.leaflet.dto.UploadDTO;
import com.scut.leaflet.repository.ShopInfoRepository;
import com.scut.leaflet.repository.UserIdRepository;
import com.scut.leaflet.service.ShopInfoService;
import com.scut.leaflet.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import com.scut.leaflet.utils.picUtil;

import static com.scut.leaflet.utils.picUtil.singleFileUpload;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 18:39
 */

@RestController
@RequestMapping("/leaf")
@Slf4j
public class UpLeafletController {
    @Autowired
    ShopInfoRepository shopInfoRepository;

    @Autowired
    UserIdRepository userIdRepository;

    @Autowired
    ShopInfoService shopInfoService;
    @Transactional
    @RequestMapping("/createDTO")
    public UploadDTO createDTO(UploadDTO uploadDTO, MultipartFile pc1,MultipartFile pc2) throws IOException {

        MultipartFile file = pc1;

      //String result= singleFileUpload(pc1,uploadDTO.);
        String result = "";
        /*//同时建立了商户表
        shopInfoService.create1(uploadDTO);
        //建立传单表，并
        UserId userId1 = new UserId();
        //openId
        userId1.setOpenId(uploadDTO.getOpenId());
        userId1.setUuid(key.unique());
        userIdRepository.save(userId1);*/
       // UserId userId2 =;


      //shopInfoRepository.save(shopInfo);
        shopInfoService.create1(uploadDTO,pc1,pc2);


        System.out.println("执行完毕"+result);







        return null;
    }
}