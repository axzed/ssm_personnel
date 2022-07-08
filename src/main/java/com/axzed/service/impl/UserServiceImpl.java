package com.axzed.service.impl;

import com.axzed.bean.AdminInfo;
import com.axzed.mapper.UserMapper;
import com.axzed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<AdminInfo> showAll() {

        try {
            List<AdminInfo> adminInfos = userMapper.showAll();
            return adminInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询管理员列表异常", e);
        }
    }

    @Override
    public AdminInfo findById(int id) {
        try {
            AdminInfo adminInfo = userMapper.findById(id);
            return adminInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更改管理员信息异常", e);
        }
    }

    @Override
    public int modify(AdminInfo adminInfo) {
        try {
            int row = userMapper.modify(adminInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改管理员信息异常", e);
        }
    }
}
