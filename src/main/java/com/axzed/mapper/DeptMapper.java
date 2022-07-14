package com.axzed.mapper;

import com.axzed.bean.DeptInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    List<DeptInfo> pageByCondition(DeptInfo deptInfo);

    int add(DeptInfo deptInfo);

    int delete(int id);

    List<DeptInfo> showAll();

    DeptInfo findById(@Param("id") int id);

    int modify(DeptInfo deptInfo);
}
