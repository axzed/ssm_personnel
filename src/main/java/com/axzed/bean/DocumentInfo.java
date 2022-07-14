package com.axzed.bean;

import lombok.Data;

import java.util.Date;

@Data
public class DocumentInfo {
    private Integer id;
    private String title;
    private String filename;
    private String remark;
    private Date createDate;
    private AdminInfo adminInfo;
}
