package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 涂德东
 * Date on 2021/7/3  15:20
 * JavaVersion 1.8
 * @Description 拦截器测试接口
 */

@RestController
public class InterceptorTestController {

    @GetMapping(value = "/test")
    public String testInterceptor(){

        return "access success";
    }
}
