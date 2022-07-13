package com.axzed.mapper;

import com.axzed.bean.EmpInfo;

import java.util.List;

public interface EmpMapper {
    List<EmpInfo> pageByCondition(EmpInfo empInfo);
}
