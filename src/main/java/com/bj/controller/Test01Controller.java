package com.bj.controller;

import com.alibaba.fastjson.JSONObject;
import com.bj.entity.*;
import com.bj.service.SysRegionService;
import com.bj.service.Test01Service;
import com.bj.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/11/30 21:22
 */
@RestController
@RequestMapping("/test01")
public class Test01Controller {

    @Autowired
    Test01Service test01Service;

    @Autowired
    SysRegionService sysRegionService;

    @Autowired
    RedisUtils redisUtils;


    @GetMapping(value = "/select")
    public List<Test01> selectAll() {
        List<Test01> list = test01Service.selectAll();
        return list;
    }

    @GetMapping(value = "/selectDate")
    public List<Date> selectDate() {
        List<Date> list = test01Service.selectDateAttribute();
        return list;
    }


    /**
     * 其中mysql表来自 https://wxzzz.com/125.html
     * 获取省市县三级联动信息+redis缓存
     * @param cityCode
     * @return
     */
    @PostMapping(value = "/selectMerchantInfo")
    public String selectPcd(String cityCode) {
        if (cityCode.isEmpty()) {
            return null;
        }
        if (redisUtils.get(cityCode) == null) {
            String value = jsonString(cityCode);
            redisUtils.set(cityCode, value, 100);
            return value;
        } else {
            return redisUtils.get(cityCode).toString();
        }

    }

    private String jsonString(String cityCode) {
        List<SysRegion> sysRegions = sysRegionService.selectByCode(cityCode);
        ZoneBusiness zoneBusiness = new ZoneBusiness();
        zoneBusiness.setStatus("0");
        zoneBusiness.setMessage("ok");
        Result result = new Result();
        result.setCity(cityCode);
        List<IdName> zonelist = new ArrayList<>();
        List<String> listcode = new ArrayList<>();
        for (SysRegion sysRegion : sysRegions) {
            IdName idName = new IdName();
            idName.setId(sysRegion.getRegionId());
            idName.setName(sysRegion.getRegionName());
            listcode.add(sysRegion.getRegionId());
            zonelist.add(idName);
        }
        result.setZone(zonelist);
        List<Business> list2 = new ArrayList<>();
        for (int i = 0; i < listcode.size(); i++) {
            Business business = new Business();
            business.setId(listcode.get(i));
            List<SysRegion> sysRegions1 = sysRegionService.selectByCode(listcode.get(i));
            List<IdName> addr = new ArrayList<>();
            for (SysRegion sysRegion : sysRegions1) {
                IdName idName = new IdName();
                idName.setId(sysRegion.getRegionId());
                idName.setName(sysRegion.getRegionName());
                addr.add(idName);
            }
            business.setAddr(addr);
            list2.add(business);
        }
        result.setBusiness(list2);
        zoneBusiness.setResult(result);
        return JSONObject.toJSON(zoneBusiness).toString();
    }

}
