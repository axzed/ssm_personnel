package com.axzed.mapper;

import com.axzed.bean.AdminInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    List<AdminInfo> showAll();

    AdminInfo findById(int id);

    int modify(AdminInfo adminInfo);

    List<AdminInfo> search(String content);

    int delete(@Param("id") int id);

    int add(AdminInfo adminInfo);

    @Update("update admin_inf set status = #{status} where id = #{id}")
    int updateStatus(@Param("id") int id, @Param("status") int status);

    List<AdminInfo> pageByCondition(AdminInfo adminInfo);
}
