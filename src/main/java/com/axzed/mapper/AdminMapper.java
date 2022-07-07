package com.axzed.mapper;

import com.axzed.bean.AdminInfo;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    AdminInfo login(@Param("username") String username, @Param("password") String password);

}
