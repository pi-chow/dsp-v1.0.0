package com.cetiti.dsp.entity;

import java.util.Date;

public class PersonGps {
    private String etlDate;
    private int gid;
    private String identityNum;
    private String name;
    private String sex;
    private String locaion;
    private Date createTime;
    private Date modify_time;
    private String locationGeo;

    public String getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(String etlDate) {
        this.etlDate = etlDate;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocaion() {
        return locaion;
    }

    public void setLocaion(String locaion) {
        this.locaion = locaion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    public String getLocationGeo() {
        return locationGeo;
    }

    public void setLocationGeo(String locationGeo) {
        this.locationGeo = locationGeo;
    }

    @Override
    public String toString() {
        return "PersonGps{" +
                "etlDate='" + etlDate + '\'' +
                ", gid=" + gid +
                ", identityNum='" + identityNum + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", locaion='" + locaion + '\'' +
                ", createTime=" + createTime +
                ", modify_time=" + modify_time +
                ", locationGeo='" + locationGeo + '\'' +
                '}';
    }
}
