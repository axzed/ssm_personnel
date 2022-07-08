package com.axzed.bean;

import lombok.Data;

import java.util.Date;

@Data
public class AdminInfo {
    private Integer id;
    private String username;
    private String password;
    private String creator;
    private Date createTime;
    private String editor;
    private Date updateTime;
    private String nickname;
}
