package com.bj.entity;

import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/5 21:21
 */
public class Result {

    String city;
    List<IdName> zone;
    List<Business> business;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<IdName> getZone() {
        return zone;
    }

    public void setZone(List<IdName> zone) {
        this.zone = zone;
    }

    public List<Business> getBusiness() {
        return business;
    }

    public void setBusiness(List<Business> business) {
        this.business = business;
    }
}
