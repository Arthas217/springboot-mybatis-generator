package com.bj.gson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author 会游泳的蚂蚁
 * @Description: https://blog.csdn.net/difffate/article/details/76600060
 * @Date 2021/12/19 11:29
 */
public class ChildrenVO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title_hello")
    private String titleHello;
    @JsonProperty("children")
    private String children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleHello() {
        return titleHello;
    }

    public void setTitleHello(String titleHello) {
        this.titleHello = titleHello;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
}
