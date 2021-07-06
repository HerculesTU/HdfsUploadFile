package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 涂德东
 * Date on 2021/7/6  10:43
 * JavaVersion 1.8
 * @Description
 */
@RestController
@RequestMapping("/query")
@Slf4j
public class QueryByPageController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "/queryByPage")
    public PageInfo<User> queryByPage(
            @RequestBody User user,
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize) {

        PageInfo<User> pageInfo = userService.queryByPage(user, pageNum, pageSize);

        return pageInfo;
    }

}
