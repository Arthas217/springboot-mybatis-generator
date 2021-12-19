package com.bj.gson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/19 11:32
 */
public class BuyInfo {
    /**
     * 买家名称
     */
    @JsonProperty("buyerName")
    private String buyerName;
    /**
     * 买家微信
     */
    @JsonProperty("buyerWechat")
    private String buyerWechat;
    /**
     * 买家代理
     */
    @JsonProperty("buyerAgender")
    private String buyerAgender;


    /**
     * 有的时候，如果有多个地方都需要这样互相转换，我们会尝试在BuyerInfo中封装一个方法，专门将对象转换成JSON字符串
     * 但是这有个坑点需要注意如果你定义了一个Java对象，定一个了一个getXXX方法，并且在该方法中调用了JSON.toJSONString方法，那么就会发生StackOverflowError！
     * @return
     */
    public String toJsonString(){
        return JSON.toJSONString(this);
    }


    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerWechat() {
        return buyerWechat;
    }

    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    public String getBuyerAgender() {
        return buyerAgender;
    }

    public void setBuyerAgender(String buyerAgender) {
        this.buyerAgender = buyerAgender;
    }
}
