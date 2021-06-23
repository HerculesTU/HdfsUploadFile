package com.demo.controller;


import com.demo.entity.Staff;
import com.demo.service.StaffService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工实体类实现接口
 */
@RestController
@RequestMapping(value = "/curd")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService staffService;


    /**
     * 根据员工id查询数据
     */
    @RequestMapping(value = "/getStaffById/{staffId}", method = RequestMethod.GET)
    @ResponseBody
    public Staff getStaffById(@PathVariable long staffId) {

        return staffService.getStaffById(staffId);
    }

    /**
     * 添加员工信息
     */
    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    public int addStaff(@RequestBody Staff staff) {

        return staffService.addStaff(staff);
    }

    /**
     * 用户修改员工信息
     */
    @RequestMapping(value = "/UpdateStaffById", method = RequestMethod.POST)
    public int UpdateStaffById(@RequestBody Staff staff) {

        return staffService.updateStaff(staff);
    }

    /**
     * 删除员工信息
     */
    @RequestMapping(value = "/deleteStaffById/{StaffId}", method = RequestMethod.POST)
    public int deleteStaffById(@PathVariable long StaffId) {

        return staffService.deleteStaff(StaffId);
    }


    /**
     * 查询所有员工信息
     */
    @RequestMapping(value = "/findAllStaff", method = RequestMethod.GET)
    public List<Staff> findAllStaff() {

        return staffService.findAllStaff();
    }

}
