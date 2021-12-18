package com.bj.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

/**
 * @Author 会游泳的蚂蚁
 * @Description: https://www.codenong.com/cs109692603/
 * @Date 2021/12/15 16:20
 */
public class JSONFieldTest {


    @Test
    public  void test() {

        Order order = new Order();
        order.setId(10001L);
        order.setCode("ABC001");
        order.setTitle("iPhone 12 即刻下单");
        order.setOrderType(1);
        order.setPrice(6688);
        order.setCtime(new Date());
        order.setPayTime(new Date());

        OrderWithAnnotation orderWithAnnotation = new OrderWithAnnotation();
        orderWithAnnotation.setId(10001L);
        orderWithAnnotation.setCode("ABC001");
        orderWithAnnotation.setTitle("iPhone 12 即刻下单");
        orderWithAnnotation.setOrderType(1);
        orderWithAnnotation.setPrice(6688);
        orderWithAnnotation.setCtime(new Date());
        orderWithAnnotation.setPayTime(new Date());


        OrderWithOrdinal orderWithOrdinal = new OrderWithOrdinal();
        orderWithOrdinal.setId(10001L);
        orderWithOrdinal.setCode("ABC001");
        orderWithOrdinal.setTitle("iPhone 12 即刻下单");
        orderWithOrdinal.setOrderType(1);
        orderWithOrdinal.setPrice(6688);
        orderWithOrdinal.setCtime(new Date());
        orderWithOrdinal.setPayTime(new Date());


        String s1 = JSON.toJSONString(order);
        String s2 = JSON.toJSONString(orderWithAnnotation);
        String s3 = JSON.toJSONString(orderWithOrdinal);
        System.out.println("原始的order：");
        System.out.println(s1);
        System.out.println("有注解的order：");
        System.out.println(s2);
        System.out.println("只有顺序注解的order：");
        System.out.println(s3);

    }
}
