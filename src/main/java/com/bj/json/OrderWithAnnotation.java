package com.bj.json;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/15 16:18
 */
public class OrderWithAnnotation {
    /**
     * 主键id
     */
    @JSONField(serialize = false)
    long id;

    /**
     * 订单编码
     */
    String code;

    /**
     * 订单标题
     */
    String title;

    /**
     * 订单价格
     */
    double price;

    /**
     * 订单类型
     */
    @JSONField(name = "order_type")
    int orderType;

    /**
     * 订单创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date ctime;

    /**
     * 订单支付时间
     */
    @JSONField(name = "pay_time", format = "yyyy-MM-dd HH:mm")
    Date payTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
