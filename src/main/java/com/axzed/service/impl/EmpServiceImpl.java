package com.axzed.service.impl;

import com.axzed.bean.EmpInfo;
import com.axzed.bean.JobInfo;
import com.axzed.mapper.EmpMapper;
import com.axzed.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<EmpInfo> pageByCondition(EmpInfo empInfo) {
        try {
            List<EmpInfo> empInfos = empMapper.pageByCondition(empInfo);
            return empInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("员工模块分页条件查询异常",e);
        }
    }

}
