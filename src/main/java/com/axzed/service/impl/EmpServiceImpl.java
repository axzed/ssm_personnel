package com.axzed.service.impl;

import com.axzed.bean.AdminInfo;
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

    @Override
    public int add(EmpInfo empInfo) {
        try {
            int row = empMapper.add(empInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("员工新增异常", e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int row = empMapper.delete(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("员工删除异常", e);
        }
    }

    @Override
    public EmpInfo findById(int id) {
        try {
            EmpInfo empInfo = empMapper.findById(id);
            return empInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询员工信息异常", e);
        }
    }

    @Override
    public int modify(EmpInfo empInfo) {
        try {
            int row = empMapper.modify(empInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改员工信息异常", e);
        }
    }

}
