package com.demo.controller;

import com.demo.entity.Grade;
import com.demo.service.GradeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Grade)表控制层
 *
 * @author makejava
 * @since 2021-07-03 17:09:18
 */
@RestController
@RequestMapping("grade")
public class GradeController {
    /**
     * 服务对象
     */
    @Resource
    private GradeService gradeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Grade selectOne(Integer id) {
        return this.gradeService.queryById(id);
    }

}
