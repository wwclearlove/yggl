package com.cdivtc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public  String  index(HttpServletRequest request){
        String realPath = request.getServletContext().getRealPath("/static/images");
        System.out.println(realPath);
        return "/index";
    }
}
