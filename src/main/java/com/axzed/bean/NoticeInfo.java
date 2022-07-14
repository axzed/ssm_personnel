package com.axzed.bean;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeInfo {
    private Integer id;
    private String title;
    private String content;
    private Date createDate;
    private AdminInfo adminInfo;
}
