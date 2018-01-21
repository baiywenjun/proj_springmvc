package com.test.genericity.domain;

import java.util.Date;

public class LogOne {
    private Long id;

    private String equmentNo;

    private Date createTime;

    private String lng;

    private String lat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEqumentNo() {
        return equmentNo;
    }

    public void setEqumentNo(String equmentNo) {
        this.equmentNo = equmentNo == null ? null : equmentNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }
}