package com.axzed.controller;

import com.axzed.bean.AdminInfo;
import com.axzed.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public String adminLogin(String rem, String username, String password, Model model, HttpSession session, HttpServletResponse response, int tip) {
        AdminInfo adminInfo = adminService.login(username, password);
        if (adminInfo != null && adminInfo.getStatus() != 0) {
            session.setAttribute("admin", adminInfo);
             //用户选择记住用户名
             //如果数据库中存在用户信息
             //查看用户是否点击记住用户名
            if (rem.equals("1")) {
                // 创建一个cookie
                Cookie cookie = new Cookie("username", adminInfo.getUsername());
                cookie.setMaxAge(68 * 68 * 24 * 7); // cookie存活时间 7days
                cookie.setPath("/");                // 设置cookie访问路径
                response.addCookie(cookie);         // 响应数据中加入cookie
            } else {
                Cookie cookie = new Cookie("username", "");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            // 自动登录
            if (rem.equals("2")) {
                Cookie autoLoginCookie = new Cookie("autoLoginCookie", adminInfo.getUsername() + "@" + adminInfo.getPassword());
                autoLoginCookie.setMaxAge(60 * 60 * 24 * 7);
                autoLoginCookie.setPath("/");
                response.addCookie(autoLoginCookie);
            } else {
                Cookie autoLoginCookie = new Cookie("autoLoginCookie", "");
                autoLoginCookie.setMaxAge(0);
                autoLoginCookie.setPath("/");
                response.addCookie(autoLoginCookie);
            }

            // 重定向到主页
            if (tip == 1 && adminInfo.getStatus() == 1) {
                session.setAttribute("tip", 1);
                return "redirect:" + "/page/index.jsp";
            } else {
                session.setAttribute("tip", 2);
                return "redirect:" + "/page/indexcustomer.jsp";
            }
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
