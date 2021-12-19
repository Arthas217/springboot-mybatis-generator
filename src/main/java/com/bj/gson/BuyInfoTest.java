package com.bj.gson;

import com.alibaba.fastjson.JSON;

/**
 * @Author 会游泳的蚂蚁
 * @Description: https://juejin.cn/post/6844903991709532173
 * @Date 2021/12/19 11:36
 */
public class BuyInfoTest {
    public static void main(String[] args) {
        BuyInfo buyerInfo = new BuyInfo();
        buyerInfo.setBuyerName("Hollis");
        JSON.toJSONString(buyerInfo);
    }
}
