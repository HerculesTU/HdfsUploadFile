package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 涂德东
 * Date on 2021/7/3  11:20
 * JavaVersion 1.8
 * @Description 测试Thymeleaf模板是否可用
 */
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {


    @GetMapping(value = "/test")
    public String ThymeleafTest(ModelMap modelMap){


        modelMap.put("hello","你好");
        return "success";
    }
}
