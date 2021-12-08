package com.bj.service.impl;

import com.bj.dao.SysRegionMapper;
import com.bj.entity.SysRegion;
import com.bj.service.SysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/6 21:54
 */
@Service
public class SysRegionServiceImpl implements SysRegionService {

    @Autowired
    SysRegionMapper sysRegionMapper;

    @Override
    public List<SysRegion> selectAll() {
        List<SysRegion> sysRegions = sysRegionMapper.selectAll();
        return sysRegions;
    }

    @Override
    public List<SysRegion> selectByCode(String cityCode) {
        return sysRegionMapper.selectByCode(cityCode);
    }
}
