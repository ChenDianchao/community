package com.youkeyuan.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/examp")

public class example {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return  "Hello 101!";
    }

}

