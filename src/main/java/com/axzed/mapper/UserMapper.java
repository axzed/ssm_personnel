package com.axzed.mapper;

import com.axzed.bean.AdminInfo;

import java.util.List;

public interface UserMapper {

    List<AdminInfo> showAll();

    AdminInfo findById(int id);

    int modify(AdminInfo adminInfo);
}
