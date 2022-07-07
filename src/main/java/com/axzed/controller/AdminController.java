package com.axzed.controller;

import com.axzed.bean.AdminInfo;
import com.axzed.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 薛文朝
 * 管理员操作表现层
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String adminLogin(String username, String password, Model model, HttpSession session) {
        AdminInfo adminInfo = adminService.login(username, password);
        if (adminInfo != null) {
            session.setAttribute("admin", adminInfo);
            return "redirect:" + "/page/index.jsp";
        } else {
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "/loginForm.jsp";
        }
    }

    /**
     * 管理员退出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String adminLogout(HttpSession session) {
        session.invalidate();
        return "/loginForm.jsp";
    }

}
