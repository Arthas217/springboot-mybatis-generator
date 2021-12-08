package com.bj.service;

import com.bj.entity.SysRegion;

import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/6 21:53
 */
public interface SysRegionService {
    List<SysRegion>  selectAll();

    List<SysRegion> selectByCode(String code);

}
