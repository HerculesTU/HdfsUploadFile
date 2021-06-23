package com.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问index.html页面
 */
@RestController
@RequestMapping(value = "/")
public class HelloController {

    public ModelAndView home() {
        return new ModelAndView("index");
    }
}
