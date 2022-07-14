package com.axzed.controller;

import com.axzed.bean.AdminInfo;
import com.axzed.common.CommonData;
import com.axzed.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @RequestMapping("/update")
    public String update(int id, Model model) {
        AdminInfo adminInfo = userService.findById(id);
        model.addAttribute("admin", adminInfo);
        return "/page/user/update.jsp";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public int modify(AdminInfo adminInfo, Model model) {
        int row = userService.modify(adminInfo);
        return row;
    }

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

    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(int[] ids) {
        // 前端通过ajax进行异步调用传入选中的id数组循环调用单个删除方法就可以了
        for (int id : ids) {
            System.out.println(id);
            userService.delete(id);
        }
        return;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "/page/user/add.jsp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(AdminInfo adminInfo, HttpServletRequest request) {
        // 获取创建时间
        Date date = new Date();
        adminInfo.setCreateTime(date);
        // 获取当前登录人信息
        AdminInfo admin = (AdminInfo)request.getSession().getAttribute("admin");
        System.out.println(adminInfo.getStatus());
        int row = userService.add(adminInfo);
        return row;
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public int updateStatus(String id, String status) {
        int newId = Integer.parseInt(id);
        int newStatus = Integer.parseInt(status);
        int updateStatus = userService.updateStatus(newId, newStatus);
        return updateStatus;
    }

    @RequestMapping("/page")
    public String pageList(@RequestParam(defaultValue = "1") int currentPage, Model model) {
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage, pageSize);
        List<AdminInfo> adminInfos = userService.showAll();
        model.addAttribute("adminList", adminInfos);
        PageInfo<AdminInfo> pageInfo = new PageInfo<>(adminInfos);
        model.addAttribute("pageInfo", pageInfo);
        return "/page/user/list.jsp";
    }

    @RequestMapping("/pageByCondition")
    public String pageByCondition(@RequestParam(defaultValue = "1") int currentPage,
                                  AdminInfo adminInfo, Model model, HttpServletRequest request){
        //拼接查询的url路径进行回传
        String path = request.getServletPath();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("?page");
        if (null != adminInfo.getNickname() && !"".equals(adminInfo.getNickname())){
            stringBuilder.append("&nickname="+adminInfo.getNickname());
        }
        String url = stringBuilder.toString();
        //添加分页功能
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage,pageSize);
        //省略list数据
        //List<AdminInfo> adminInfos = userService.showAll();
        List<AdminInfo> adminInfos = userService.pageByCondition(adminInfo);
        model.addAttribute("adminList",adminInfos);
        PageInfo<AdminInfo> pageInfo = new PageInfo<>(adminInfos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("nickname",adminInfo.getNickname());
        model.addAttribute("url",url);
        return "/page/user/list.jsp";
    }

}
