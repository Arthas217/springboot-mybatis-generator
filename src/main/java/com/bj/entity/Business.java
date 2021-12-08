package com.bj.entity;

import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/5 21:24
 */
public class Business {
    String id;
    List<IdName> addr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<IdName> getAddr() {
        return addr;
    }

    public void setAddr(List<IdName> addr) {
        this.addr = addr;
    }
}
