package com.demo.controller;

import com.demo.task.GetTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 涂德东
 * Date on 2021/7/2  16:40
 * JavaVersion 1.8
 * @Description
 */
@RestController
@RequestMapping(value = "/scheduled")
@Slf4j
public class ScheduledTaskController {

    GetTask task = new GetTask();

    @GetMapping(value = "/task")
    public void getScheduledTask(){

        task.getUserInfo();
    }
}
