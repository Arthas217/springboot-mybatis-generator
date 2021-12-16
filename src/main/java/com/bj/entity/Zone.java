package com.bj.entity;

import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/15 21:28
 */
public class Zone {
    private String zoneCode;
    private String zoneName;
    private List<Businesss> business;

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public List<Businesss> getBusiness() {
        return business;
    }

    public void setBusiness(List<Businesss> business) {
        this.business = business;
    }
}
