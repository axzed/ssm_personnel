package com.axzed.controller;

import com.axzed.bean.DeptInfo;
import com.axzed.bean.EmpInfo;
import com.axzed.bean.JobInfo;
import com.axzed.common.CommonData;
import com.axzed.service.DeptService;
import com.axzed.service.EmpService;
import com.axzed.service.JobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private JobService jobService;

    @RequestMapping("/pageByCondition")
    public String pageByCondition(@RequestParam(defaultValue = "1") int currentPage,
                                  EmpInfo empInfo, Model model, HttpServletRequest request){
        //拼接查询的url路径进行回传
        String path = request.getServletPath();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("?page");
        if (null != empInfo.getName() && !"".equals(empInfo.getName())){
            stringBuilder.append("&name="+empInfo.getName());
        }
        String url = stringBuilder.toString();
        //添加分页功能
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage,pageSize);
        //省略list数据
        //List<AdminInfo> adminInfos = userService.showAll();
        List<EmpInfo> empInfos = empService.pageByCondition(empInfo);
        model.addAttribute("empList",empInfos);
        PageInfo<EmpInfo> pageInfo = new PageInfo<>(empInfos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",empInfo.getName());
        model.addAttribute("url",url);
        return "/page/employee/list.jsp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        List<DeptInfo> deptInfos = deptService.showAll();
        List<JobInfo> jobInfos = jobService.showAll();
        model.addAttribute("deptInfos", deptInfos);
        model.addAttribute("jobInfos", jobInfos);
        return "/page/employee/add.jsp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(EmpInfo empInfo) {
        return "redirect:/page/index.jsp";
    }


}
