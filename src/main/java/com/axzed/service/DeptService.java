package com.axzed.service;

import com.axzed.bean.DeptInfo;
import com.axzed.bean.JobInfo;

import java.util.List;

public interface DeptService {

    List<DeptInfo> pageByCondition(DeptInfo deptInfo);

    void add(DeptInfo deptInfo);

    int delete(int id);
}
