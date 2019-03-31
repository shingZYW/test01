package com.scut.leaflet.repository;

import com.scut.leaflet.dataobject.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ass we can!
 * created by shing
 * 2019-03-28 21:24
 */
public interface UserIdRepository extends JpaRepository<UserId,String> {
    //UserId findByOpenId(String openId);
}
