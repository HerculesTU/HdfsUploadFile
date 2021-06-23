package com.demo.service;


import com.demo.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工业务层
 */
@Service
public interface StaffService {

    /**
     * 根据id查询员工信息
     */
    Staff getStaffById(long staffId);

    /**
     * 添加员工信息
     */
    int addStaff(Staff staff);

    /**
     * 修改员工信息
     */
    int updateStaff(Staff staff);

    /**
     * 删除员工信息
     */
    int deleteStaff(long staffId);

    /**
     * 查询所有员工信息
     */
    List<Staff> findAllStaff();

}
