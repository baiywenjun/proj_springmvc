package com.erdangjia.entity;

public class TbEqument {
    private Long id;

    private String equmentName;

    private String equmentNo;

    private String accountName;

    private String remark;

    private String createTime;

    private String equmentType;

    private String ip;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEqumentName() {
        return equmentName;
    }

    public void setEqumentName(String equmentName) {
        this.equmentName = equmentName == null ? null : equmentName.trim();
    }

    public String getEqumentNo() {
        return equmentNo;
    }

    public void setEqumentNo(String equmentNo) {
        this.equmentNo = equmentNo == null ? null : equmentNo.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getEqumentType() {
        return equmentType;
    }

    public void setEqumentType(String equmentType) {
        this.equmentType = equmentType == null ? null : equmentType.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}