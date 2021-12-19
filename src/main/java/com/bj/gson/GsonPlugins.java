package com.bj.gson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/12/18 16:54
 */

public class GsonPlugins {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title_hello")
    private String titleHello;
    @JsonProperty("children")
    private List<ChildrenVO> children;

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

    public List<ChildrenVO> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenVO> children) {
        this.children = children;
    }
}
