package com.scut.leaflet.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ass we can!
 * created by shing
 * 2019-03-26 16:55
 */
@Data
@Entity
public class Forwarder {

    @Id
    private String openId;

    private String name;


    private Date createTime;

    /** 更新时间. */
    private Date updateTime;


    private BigDecimal rmb;

    public Forwarder() {
    }
}
