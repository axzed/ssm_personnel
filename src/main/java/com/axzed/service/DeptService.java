package com.axzed.service;

import com.axzed.bean.DeptInfo;

import java.util.List;
import java.util.Map;

public interface DeptService {

    List<DeptInfo> showAll();

    List<DeptInfo> pageByCondition(DeptInfo deptInfo);

    int add(DeptInfo deptInfo);

    int delete(int id);

    DeptInfo findById(int id);

    int modify(DeptInfo deptInfo);

    // 查询部门下员工数量
    List<Map<String, Object>> employeeCount();
}
