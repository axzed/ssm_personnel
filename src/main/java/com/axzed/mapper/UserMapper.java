package com.axzed.mapper;

import com.axzed.bean.AdminInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<AdminInfo> showAll();

    AdminInfo findById(int id);

    int modify(AdminInfo adminInfo);

    List<AdminInfo> search(String content);

    int delete(@Param("id") int id);
}
