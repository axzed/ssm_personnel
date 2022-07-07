package com.axzed.service.impl;

import com.axzed.bean.AdminInfo;
import com.axzed.mapper.AdminMapper;
import com.axzed.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminInfo login(String username, String password) {
        try {
            AdminInfo adminInfo = adminMapper.login(username, password);
            return adminInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("管理员登录异常", e);
        }
    }

}
