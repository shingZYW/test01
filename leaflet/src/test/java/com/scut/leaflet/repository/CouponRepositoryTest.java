package com.scut.leaflet.repository;

import com.scut.leaflet.dataobject.Coupon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * ass we can!
 * created by shing
 * 2019-03-27 22:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponRepositoryTest {

    @Autowired
    private CouponRepository couponRepository;

    @Test
    public void saveTest(){
        Coupon coupon = new Coupon();
        coupon.setCouponId("qwewqrwq");
        coupon.setCoupon("优惠券");
        couponRepository.save(coupon);
        System.out.println(coupon);


    }

}