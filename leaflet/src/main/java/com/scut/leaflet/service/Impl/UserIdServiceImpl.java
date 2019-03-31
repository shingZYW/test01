package com.scut.leaflet.service.Impl;

import com.scut.leaflet.dataobject.UserId;
import com.scut.leaflet.repository.UserIdRepository;
import com.scut.leaflet.service.UserIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ass we can!
 * created by shing
 * 2019-03-28 22:44
 */
@Service
@Slf4j
public class UserIdServiceImpl implements UserIdService {

    @Autowired
    UserIdRepository userIdRepository;

    @Override
    public UserId findById(String openId) {
        return (UserId) userIdRepository.findById(openId).orElse(null);
    }

    /*public UserId findById(String openId) {
        return userIdRepository.findById(openId);
    }*/
}
