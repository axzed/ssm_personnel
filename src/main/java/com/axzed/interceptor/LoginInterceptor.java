package com.axzed.interceptor;

import com.axzed.bean.AdminInfo;
import com.axzed.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getServletPath();
        String[] ignoreUrls = {"/login", "/css", "/images", "/js"};
        for (String ignoreUrl : ignoreUrls) {
            if (url.indexOf(ignoreUrl) != -1) {
                return true;
            }
        }

        HttpSession session = request.getSession();
        AdminInfo admin = (AdminInfo) session.getAttribute("admin");
        if (admin != null) {
            return true;
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("autoLoginCookie".equals(cookie.getName())) {
                    String[] arr = cookie.getValue().split("@");
                    String username = arr[0];
                    String password = arr[1];

                    AdminInfo login = adminService.login(username, password);
                    if (login != null) {
                        session.setAttribute("admin", login);
                        return true;
                    }
                }
            }
        }

        request.setAttribute("errorMsg", "您还没有登录，请先登录");
        request.getRequestDispatcher("/loginForm.jsp").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
