package com.axzed.bean;

import lombok.Data;

@Data
public class JobInfo {
    private Integer id;
    private String name;
    private String remark; // 标注
    private Integer deptId;

    // 职位对应部门信息
    private DeptInfo deptInfo;
}
