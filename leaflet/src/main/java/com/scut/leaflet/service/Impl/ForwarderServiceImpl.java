package com.scut.leaflet.service.Impl;

import com.scut.leaflet.controller.key;
import com.scut.leaflet.dataobject.Forwarder;
import com.scut.leaflet.dataobject.Leaflet;
import com.scut.leaflet.dataobject.UserId;
import com.scut.leaflet.repository.ForwarderRepository;
import com.scut.leaflet.repository.LeafletRepository;
import com.scut.leaflet.repository.UserIdRepository;
import com.scut.leaflet.service.ForwarderService;
import com.scut.leaflet.service.UserIdService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 18:03
 */
public class ForwarderServiceImpl implements ForwarderService {


    @Autowired
    ForwarderRepository forwarderRepository;

    @Autowired
    UserIdRepository userIdRepository;

    @Autowired
    LeafletRepository leafletRepository;

    @Override
    public Forwarder findone(String openId) {
        return null;
    }

    @Override
    public List<Forwarder> findUpAll() {
        return null;
    }

    @Autowired
    UserIdService userIdService;

    @Override
    public String forwarder(String leafletId,String openId,String name) {

        if(!userIdService.findById(openId).toString().isEmpty()){
            UserId userId = new UserId();
            Forwarder forwarder  = new Forwarder();
            //将openId与uuid成对保存
            String s = key.unique();
            userId.setUuid(s);
            userId.setOpenId(openId);
            userIdRepository.save(userId);
            //建立转发表
            forwarder.setName(name);
            forwarder.setOpenId(s);
           //检查传单表
            Leaflet leaflet1=leafletRepository.findByLeafletId(leafletId);
            BigDecimal rmb = new BigDecimal(0.5);
            if(leaflet1.getLeafletPrice().compareTo(new BigDecimal(0))==1)
            forwarder.setRmb(forwarder.getRmb().add(rmb));
            leaflet1.setLeafletPrice(leaflet1.getLeafletPrice().divide(new BigDecimal(0.5)));
            leafletRepository.save(leaflet1);
            forwarderRepository.save(forwarder);
            return "红包派发中";
        }else {
        return "红包发完了哦！";

        }


    }

    //接收第一次上传所有的东西，图片所有东西，
    @Override
    public Forwarder create(Forwarder forwarder ) {
        Forwarder forwarder1 ;

        forwarder1 = forwarderRepository.findById(forwarder.getOpenId()).orElse(null);
        if(forwarder1!=null){
            //当该转发者增加券，增加，钱的数目
               //当券已经存在时退出
                //当全



        }


        ;



        return null;
    }
}
