package com.axzed.service;

import com.axzed.bean.AdminInfo;

import java.util.List;

public interface UserService {
    List<AdminInfo> showAll();

    AdminInfo findById(int id);

    int modify(AdminInfo adminInfo);

    List<AdminInfo> search(String content);

    int delete(int id);

    void add(AdminInfo adminInfo);

    int updateStatus(int newId, int newStatus);

    List<AdminInfo> pageByCondition(AdminInfo adminInfo);
}
