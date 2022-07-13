package com.axzed.controller;

import com.axzed.bean.DeptInfo;
import com.axzed.bean.JobInfo;
import com.axzed.common.CommonData;
import com.axzed.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/pageByCondition")
    public String pageByCondition(@RequestParam(defaultValue = "1") int currentPage,
                                  DeptInfo deptInfo, Model model, HttpServletRequest request){
        //拼接查询的url路径进行回传
        String path = request.getServletPath();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("?page");
        if (null != deptInfo.getName() && !"".equals(deptInfo.getName())){
            stringBuilder.append("&name="+deptInfo.getName());
        }
        String url = stringBuilder.toString();
        //添加分页功能
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage,pageSize);
        //省略list数据
        //List<AdminInfo> adminInfos = userService.showAll();
        List<DeptInfo> deptInfos = deptService.pageByCondition(deptInfo);
        model.addAttribute("deptList",deptInfos);
        PageInfo<DeptInfo> pageInfo = new PageInfo<>(deptInfos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",deptInfo.getName());
        model.addAttribute("url",url);
        return "/page/dept/list.jsp";
    }

    @RequestMapping("/add")
    public String add() {
        return "/page/dept/add.jsp";
    }

    @RequestMapping("/addDeptInfo")
    public String addDeptInfo(DeptInfo deptInfo) {
        deptService.add(deptInfo);
        return "/page/dept/list.jsp";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int id, Model model) {
        System.out.println(id);
        int row = deptService.delete(id);
        return row;
    }

    /**
     * 批量删除
     * @param ids
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(int[] ids) {
        // 前端通过ajax进行异步调用传入选中的id数组循环调用单个删除方法就可以了
        for (int id : ids) {
            System.out.println(id);
            int i = deptService.delete(id);
            System.out.println(i);
        }
        return;
    }

}