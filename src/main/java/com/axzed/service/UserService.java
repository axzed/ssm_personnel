package com.axzed.service;

import com.axzed.bean.AdminInfo;

import java.util.List;

public interface UserService {
    List<AdminInfo> showAll();

    AdminInfo findById(int id);

    int modify(AdminInfo adminInfo);

    List<AdminInfo> search(String content);

}
