package com.axzed.controller;

import com.axzed.bean.AdminInfo;
import com.axzed.bean.DeptInfo;
import com.axzed.bean.JobInfo;
import com.axzed.common.CommonData;
import com.axzed.service.DeptService;
import com.axzed.service.JobService;
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
import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    @RequestMapping("/pageByCondition")
    public String pageByCondition(@RequestParam(defaultValue = "1") int currentPage,
                                  JobInfo jobInfo, Model model, HttpServletRequest request){
        //拼接查询的url路径进行回传
        String path = request.getServletPath();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("?page");
        if (null != jobInfo.getName() && !"".equals(jobInfo.getName())){
            stringBuilder.append("&name="+jobInfo.getName());
        }
        String url = stringBuilder.toString();
        //添加分页功能
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage,pageSize);
        //省略list数据
        //List<AdminInfo> adminInfos = userService.showAll();
        List<JobInfo> jobInfos = jobService.pageByCondition(jobInfo);
        model.addAttribute("jobList",jobInfos);
        PageInfo<JobInfo> pageInfo = new PageInfo<>(jobInfos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",jobInfo.getName());
        model.addAttribute("url",url);
        return "/page/job/list.jsp";
    }

    /**
     * 展示添加
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        List<DeptInfo> deptInfos = deptService.showAll();
        model.addAttribute("deptInfos", deptInfos);
        return "/page/job/add.jsp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int addJobInfo(JobInfo jobInfo) {
        int row = jobService.add(jobInfo);
        return row;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int id, Model model) {
        System.out.println(id);
        int row = jobService.delete(id);
        return row;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(int[] ids) {
        // 前端通过ajax进行异步调用传入选中的id数组循环调用单个删除方法就可以了
        for (int id : ids) {
            System.out.println(id);
            int i = jobService.delete(id);
            System.out.println(i);
        }
        return;
    }

    @RequestMapping("/update")
    public String update(int id, Model model) {
        JobInfo jobInfo = jobService.findById(id);
        List<DeptInfo> deptInfos = deptService.showAll();
        model.addAttribute("job", jobInfo);
        model.addAttribute("deptInfos", deptInfos);
        return "/page/job/update.jsp";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public int modify(JobInfo jobInfo , Model model) {
        int row = jobService.modify(jobInfo);
        return row;
    }

}
