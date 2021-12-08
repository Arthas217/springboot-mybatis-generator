package com.bj.service;

import com.bj.entity.Test01;

import java.util.Date;
import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/11/30 21:23
 */
public interface Test01Service {

    /**
     * 查询
     * @return
     */
    List<Test01> selectAll();


    List<Date> selectDateAttribute();
}
