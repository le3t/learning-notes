package org.ko.web.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserQueryCondition {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户年龄起始值")
    private int age;

    @ApiModelProperty("用户名年龄终止值")
    private int ageTo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }
}
