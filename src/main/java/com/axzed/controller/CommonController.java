package com.axzed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class CommonController {
    @RequestMapping("/welcome")
    public String welcome(Model model) {

        Date date = new Date();

        model.addAttribute("current_date", date);

        return "/page/welcome.jsp";
    }
}
