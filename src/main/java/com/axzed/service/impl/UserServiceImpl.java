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
            throw new RuntimeException("查询管理员信息异常", e);
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

    @Override
    public List<AdminInfo> search(String content) {
        try {
            List<AdminInfo> adminInfos = userMapper.search(content);
            return adminInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查找管理员异常", e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int row = userMapper.delete(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("管理员删除异常", e);
        }
    }

    @Override
    public void add(AdminInfo adminInfo) {
        try {
            userMapper.add(adminInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("管理员删除异常", e);
        }
    }

    @Override
    public int updateStatus(int id, int status) {
        try {

            //1.根据id信息以及状态信息进行管理员状态修改
            if(status == 1){//当前为启用状态，需执行禁用功能

                status = 0;

                //进入service进行修改数据库中管理员状态
                int row = userMapper.updateStatus(id, status);

                //如果数据库执行修改成功
                if (row !=0){//代表禁用操作成功
                    return status;
                }else{
                    status = 2;//代表数据库执行修改失败
                    return status;
                }

            }else{//当前为禁用状态，需执行启用功能

                status = 1;

                //进入service进行修改数据库中管理员状态
                int row = userMapper.updateStatus(id, status);

                //如果数据库执行修改成功
                if (row !=0){
                    return status;//代表启用操作成功
                }else{
                    status = 2;//代表数据库执行修改失败
                    return status;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户模块管理员状态修改异常",e);
        }
    }

    @Override
    public List<AdminInfo> pageByCondition(AdminInfo adminInfo) {
        try {
            List<AdminInfo> adminInfos = userMapper.pageByCondition(adminInfo);
            return adminInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户模块管理员分页条件查询异常",e);
        }
    }

}
