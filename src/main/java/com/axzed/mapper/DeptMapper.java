package com.axzed.mapper;

import com.axzed.bean.DeptInfo;
import com.axzed.bean.JobInfo;

import java.util.List;

public interface DeptMapper {
    List<DeptInfo> pageByCondition(DeptInfo deptInfo);

    void add(DeptInfo deptInfo);

    int delete(int id);

    List<DeptInfo> showAll();
}