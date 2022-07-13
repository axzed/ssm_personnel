package com.axzed.service;

import com.axzed.bean.EmpInfo;

import java.util.List;

public interface EmpService {
    List<EmpInfo> pageByCondition(EmpInfo empInfo);
}
