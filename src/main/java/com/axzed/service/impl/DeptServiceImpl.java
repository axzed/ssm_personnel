package com.axzed.service.impl;

import com.axzed.bean.DeptInfo;
import com.axzed.bean.JobInfo;
import com.axzed.mapper.DeptMapper;
import com.axzed.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<DeptInfo> pageByCondition(DeptInfo deptInfo) {
        try {
            List<DeptInfo> deptInfos = deptMapper.pageByCondition(deptInfo);
            return deptInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("部门模块分页条件查询异常",e);
        }
    }

    @Override
    public void add(DeptInfo deptInfo) {
        try {
            deptMapper.add(deptInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("部门增加异常", e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int row = deptMapper.delete(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("部门删除异常", e);
        }
    }

}
