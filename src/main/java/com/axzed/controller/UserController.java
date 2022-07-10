package com.axzed.controller;

import com.axzed.bean.AdminInfo;
import com.axzed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 薛文朝
 * 用户管理模块
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String showList(Model model) {
        List<AdminInfo> adminInfos = userService.showAll();
        model.addAttribute("adminList", adminInfos);
        return "/page/user/list.jsp";
    }

    /**
     * 修改管理员信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public String update(int id, Model model) {
        AdminInfo adminInfo = userService.findById(id);
        model.addAttribute("admin", adminInfo);
        return "/page/user/update.jsp";
    }

    /**
     * 修改管理员信息
     * @param adminInfo
     * @param model
     * @return
     */
    @RequestMapping("/modify")
    public String modify(AdminInfo adminInfo, Model model) {
        int row = userService.modify(adminInfo);
        if (row != 0) {
            List<AdminInfo> adminInfos = userService.showAll();
            model.addAttribute("adminList", adminInfos);
            return "/page/user/list.jsp";
        } else {
            model.addAttribute("errorMsg", "修改管理员信息异常");
            return "/page/user/update.jsp";
        }
    }

    /**
     * 管理员信息模糊查询
     * @param content
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String search(String content, Model model) {
        List<AdminInfo> adminInfos = userService.search(content);
        model.addAttribute("adminList", adminInfos);
        return "/page/user/list.jsp";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int id, Model model) {
        System.out.println(id);
        int row = userService.delete(id);
        return row;
    }

    /**
     * 展示添加
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "/page/user/add.jsp";
    }

    @RequestMapping("/addUserInfo")
    public String addUserInfo() {

        return "/page/user/list.jsp";
    }
}
