package com.scut.leaflet.service;

import com.scut.leaflet.dataobject.ShopInfo;
import com.scut.leaflet.dto.UploadDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 10:19
 */
public interface ShopInfoService {

    String create1(UploadDTO uploadDTO, MultipartFile pc1,MultipartFile pc2) throws IOException;

    String test();


}
