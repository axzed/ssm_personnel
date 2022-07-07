package com.axzed.service;

import com.axzed.bean.AdminInfo;

public interface AdminService {

    AdminInfo login(String username, String password);

}
