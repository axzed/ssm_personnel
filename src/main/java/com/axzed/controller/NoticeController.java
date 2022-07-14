package com.axzed.controller;

import com.axzed.bean.*;
import com.axzed.common.CommonData;
import com.axzed.service.AdminService;
import com.axzed.service.NoticeService;
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

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private UserService userService;

    @RequestMapping("/pageByCondition")
    public String pageByCondition(@RequestParam(defaultValue = "1") int currentPage,
                                  NoticeInfo noticeInfo, Model model, HttpServletRequest request){
        //拼接查询的url路径进行回传
        String path = request.getServletPath();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("?page");
        if (null != noticeInfo.getTitle() && !"".equals(noticeInfo.getTitle())){
            stringBuilder.append("&title="+noticeInfo.getTitle());
        }
        String url = stringBuilder.toString();
        //添加分页功能
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage,pageSize);
        //省略list数据
        //List<AdminInfo> adminInfos = userService.showAll();
        List<NoticeInfo> noticeInfos = noticeService.pageByCondition(noticeInfo);
        model.addAttribute("noticeList",noticeInfos);
        PageInfo<NoticeInfo> pageInfo = new PageInfo<>(noticeInfos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("title",noticeInfo.getTitle());
        model.addAttribute("url",url);
        return "/page/notice/list.jsp";
    }

    //跳转到管理员添加页面
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return  "/page/notice/add.jsp";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public int add(NoticeInfo noticeInfo,HttpServletRequest request){
        Date date = new Date();
        noticeInfo.setCreateDate(date);
        AdminInfo admin = (AdminInfo)request.getSession().getAttribute("admin");
        noticeInfo.setAdminInfo(admin);
        int row = noticeService.save(noticeInfo);
        return row;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int id){
        int row =  noticeService.delete(id);
        return row;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(int[] ids) {
        for (int id : ids) {
            System.out.println(id);
            noticeService.delete(id);
        }
        return;
    }

    @RequestMapping("/update")
    public String update(int id, Model model) {
        NoticeInfo noticeInfo = noticeService.findById(id);
        model.addAttribute("notice", noticeInfo);
        return "/page/notice/update.jsp";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public int modify(NoticeInfo noticeInfo, HttpServletRequest request, Model model) {
        int row = noticeService.update(noticeInfo);
        return row;
    }

}
