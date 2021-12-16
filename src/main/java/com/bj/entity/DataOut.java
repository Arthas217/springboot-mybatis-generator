package com.bj.entity;

import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/15 21:26
 */
public class DataOut {
    private String cityCode;
    private List<Zone> zone;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public List<Zone> getZone() {
        return zone;
    }

    public void setZone(List<Zone> zone) {
        this.zone = zone;
    }
}
