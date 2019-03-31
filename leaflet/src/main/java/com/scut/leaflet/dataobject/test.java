package com.scut.leaflet.dataobject;

import com.scut.leaflet.dto.UploadDTO;
import com.scut.leaflet.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 22:52
 */
@Controller
@RequestMapping("/test")
public class  test {
/*    public static void main(String[] args){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();

        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        System.out.println(temp);

        S
    }*/
    @Autowired
    private  ShopInfoService shopInfoService;

    @PostMapping("/1")
    public String add(MultipartFile pc1, MultipartFile pc2) throws IOException {
        UploadDTO uploadDTO = new UploadDTO();
        uploadDTO.setOpenId("1323h1213");
        uploadDTO.setCoupon("满减30");
        uploadDTO.setLeafletPrice(new BigDecimal(100));
        uploadDTO.setProductIcon1("第一张图片");
        uploadDTO.setProductIcon2("第二张图片");
        uploadDTO.setShopName("shing");
        uploadDTO.setCoupon("预先设置");
        System.out.println(uploadDTO);
        System.out.println(pc1+"图2："+pc2);


        String w = shopInfoService.test();

        System.out.println(w);
        String s =shopInfoService.create1(uploadDTO,pc1,pc2);






        return "成功"+s;


    }


}
