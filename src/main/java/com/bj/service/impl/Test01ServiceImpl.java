package com.bj.service.impl;

import com.bj.dao.Test01Mapper;
import com.bj.entity.Test01;
import com.bj.service.Test01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/11/30 21:28
 */
@Service
public class Test01ServiceImpl implements Test01Service {

    @Autowired
    Test01Mapper test01Mapper;

    @Override
    public List<Test01> selectAll() {
        return test01Mapper.selectAll();
    }

    @Override
    public List<Date> selectDateAttribute() {
        List<Date> dates = test01Mapper.selectDataAttribute();
        return dates;
    }
}
