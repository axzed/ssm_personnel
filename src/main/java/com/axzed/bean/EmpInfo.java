package com.axzed.bean;

import lombok.Data;

import java.util.Date;

@Data
public class EmpInfo {

    private Integer id;
    private String name;
    private String password;
    private String cardId;
    private String address;
    private String phone;
    private Integer sex;
    private Date birthday;
    private String education;
    private String remark;
    private String email;
    private Date createDate;

    private DeptInfo deptInfo;
    private JobInfo jobInfo;

}
