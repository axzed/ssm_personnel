package com.axzed.controller;

import com.axzed.bean.NoticeInfo;
import com.axzed.bean.StudentInfo;
import com.axzed.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        List<NoticeInfo> noticeInfos = noticeService.showAll();
        model.addAttribute("noticeInfos",noticeInfos);
        return "/page/welcome.jsp";
    }

    @RequestMapping("/showZhuImage")
    public String showZhuImage() {
        return "/page/chart_zhu.html";
    }

    @RequestMapping("/score_chart")
    @ResponseBody
    public List<StudentInfo> scoreChart() {
        ArrayList<StudentInfo> studentInfos = new ArrayList<>();
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentName("张三");
        studentInfo.setTotalScore(85);
        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setStudentName("李四");
        studentInfo1.setTotalScore(78);
        StudentInfo studentInfo2 = new StudentInfo();
        studentInfo2.setStudentName("王五");
        studentInfo2.setTotalScore(67);
        StudentInfo studentInfo3 = new StudentInfo();
        studentInfo3.setStudentName("赵六");
        studentInfo3.setTotalScore(61);
        StudentInfo studentInfo4 = new StudentInfo();
        studentInfo4.setStudentName("苏七");
        studentInfo4.setTotalScore(56);
        StudentInfo studentInfo5 = new StudentInfo();
        studentInfo5.setStudentName("钱八");
        studentInfo5.setTotalScore(85);
        studentInfos.add(studentInfo);
        studentInfos.add(studentInfo1);
        studentInfos.add(studentInfo2);
        studentInfos.add(studentInfo3);
        studentInfos.add(studentInfo4);
        studentInfos.add(studentInfo5);
        return studentInfos;
    }

}
