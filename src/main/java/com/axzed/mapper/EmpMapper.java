package com.axzed.mapper;

import com.axzed.bean.EmpInfo;

import java.util.List;

public interface EmpMapper {

    List<EmpInfo> pageByCondition(EmpInfo empInfo);

    int add(EmpInfo empInfo);

    int delete(int id);

    EmpInfo findById(int id);

    int modify(EmpInfo empInfo);
}
