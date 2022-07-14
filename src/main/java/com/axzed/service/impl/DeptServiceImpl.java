package com.axzed.service.impl;

import com.axzed.bean.DeptInfo;
import com.axzed.mapper.DeptMapper;
import com.axzed.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<DeptInfo> showAll() {
        try {
            List<DeptInfo> deptInfos = deptMapper.showAll();
            return deptInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询部门列表异常", e);
        }
    }

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
    public int add(DeptInfo deptInfo) {
        try {
            int row = deptMapper.add(deptInfo);
            return row;
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

    @Override
    public DeptInfo findById(int id) {
        try {
            DeptInfo deptInfo  = deptMapper.findById(id);
            return deptInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询部门信息异常", e);
        }
    }

    @Override
    public int modify(DeptInfo deptInfo) {
        try {
            int row = deptMapper.modify(deptInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改部门信息异常", e);
        }
    }

    @Override
    public List<Map<String, Object>> employeeCount() {
        try {
            List<Map<String, Object>> list = deptMapper.employeeCount();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("部门人数统计异常",e);
        }
    }

}
