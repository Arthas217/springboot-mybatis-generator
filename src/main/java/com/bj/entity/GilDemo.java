package com.bj.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/15 21:16
 */
public class GilDemo {
    private static final String str = "{\"responseHeader\":{\"status\":0,\"QTime\":0},\"response\":{\"numFound\":5,\"docs\":[{\"business_code\":[\"101\"],\"business_name\":[\"望京\"],\"city_code\":\"101001\",\"zone_code\":\"100\",\"zone_name\":\"朝阳\"},{\"business_code\":[\"103,106\"],\"business_name\":[\"阜通,俸伯\"],\"city_code\":\"101001\",\"zone_code\":\"100\",\"zone_name\":\"朝阳\"},{\"business_code\":[\"104\"],\"business_name\":[\"大望路\"],\"city_code\":\"101001\",\"zone_code\":\"100\",\"zone_name\":\"朝阳\"},{\"business_code\":[\"201,202,203\"],\"business_name\":[\"回龙观, 天通苑,小汤山\"],\"city_code\":\"101001\",\"zone_code\":\"200\",\"zone_name\":\"海淀\"},{\"business_code\":[\"204\"],\"business_name\":[\"霍营\"],\"city_code\":\"101001\",\"zone_code\":\"200\",\"zone_name\":\"海淀\"}]},\"facet_counts\":{\"facet_queries\":{},\"facet_fields\":{\"business_code\":[\"204\",90,\"104\",80,\"103,106\",70,\"201,202,203\",60,\"101\",50]},\"facet_intervals\":{}}}";

    private static DataOut getJsonZoneBusinessByCode(String cityCode) {
        Map<String, Object> responseMap = (Map) JSON.parse(str);
        Map<String, Object> map = (Map) responseMap.get("responseHeader");
        if (map.get("status").toString().equals("0")) {
            if (responseMap.get("facet_counts") == null || responseMap.get("response") == null) {
                return null;
            }
            Map<String, Object> facetMap = (Map) responseMap.get("facet_counts");
            Map<String, Object> facetFields = (Map<String, Object>) facetMap.get("facet_fields");
            JSONArray jsonArray = (JSONArray) facetFields.get("business_code");
            Map<String, Object> response = (Map) responseMap.get("response");
            List<Map<String, Object>> docs = (List) response.get("docs");

            // 获取商圈code集合有序
            List<String> businessCode = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                businessCode.add(jsonArray.getString(i++));
            }

            List<Zone> zones = new ArrayList<>();
            //初始化固定值-全城
            Zone initZone = new Zone();
            initZone.setZoneCode("0");
            initZone.setZoneName("全城");
            Businesss initBusiness = new Businesss();
            initBusiness.setBusinessCode(Arrays.asList("0"));
            initBusiness.setBusinessName(Arrays.asList("全城"));
            initZone.setBusiness(Arrays.asList(initBusiness));
            zones.add(initZone);

            Map<String, String> bzMap = new HashMap<>();
            Map<String, Zone> zoneMap = new HashMap<>();
            Map<String, String> cnMap = new HashMap<>();

            //遍历docs 设置zoneCode和zone_name;
            docs.forEach(doc -> {
                JSONArray match = (JSONArray) doc.get("business_code");
                JSONArray busName = (JSONArray) doc.get("business_name");
                List<String> code = match.toJavaList(String.class);
                List<String> name = busName.toJavaList(String.class);
                cnMap.put(code.get(0), name.get(0));
                StringBuffer stringBuffer = new StringBuffer();
                match.stream().map(Object::toString).forEach(stringBuffer::append);
                bzMap.put(stringBuffer.toString(), (String) doc.get("zone_code"));
                boolean zone_code = zones.stream().anyMatch(zone -> zone.getZoneCode().equals(doc.get("zone_code")));
                if (!zone_code) {
                    Zone zone = new Zone();
                    zone.setZoneCode((String) doc.get("zone_code"));
                    zone.setZoneName((String) doc.get("zone_name"));
                    zoneMap.put((String) doc.get("zone_code"), zone);
                    zones.add(zone);
                }
            });

            businessCode.forEach(bcode -> {
                String s = bzMap.get(bcode);
                Zone zone = zoneMap.get(s);
                if (zone.getBusiness() == null) {
                    List<Businesss> businessList = new ArrayList<>();
                    List<String> codeList = new ArrayList<>();
                    List<String> nameList = new ArrayList<>();
                    Businesss businesss = new Businesss();
                    codeList.add(bcode);
                    nameList.add(cnMap.get(bcode));
                    businesss.setBusinessCode(codeList);
                    businesss.setBusinessName(nameList);
                    businessList.add(businesss);
                    zone.setBusiness(businessList);
                } else {
                    List<Businesss> list = zone.getBusiness();
                    list.stream().forEach(businesss -> {
                        List<String> businessCode1 = businesss.getBusinessCode();
                        businessCode1.add(bcode);
                        List<String> businessName = businesss.getBusinessName();
                        businessName.add(cnMap.get(bcode));
                    });
                }
            });
            DataOut dataOut = new DataOut();
            dataOut.setCityCode(cityCode);
            dataOut.setZone(zones);
            return dataOut;
        }
        return new DataOut();
    }



    public static void main(String[] args) {
        DataOut result = getJsonZoneBusinessByCode("110100");
        System.out.println(JSONArray.toJSONString(result));

    }
}
