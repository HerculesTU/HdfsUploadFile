package com.demo.service.impl;

import com.demo.entity.Staff;
import com.demo.mapper.StaffMapper;
import com.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 员工业务实现类
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {


    @Autowired
    public StaffMapper staffMapper;

    /**
     * 根据员工id查询员工信息
     *
     * @param staffId 员工id
     * @return
     */
    @Override
    public Staff getStaffById(long staffId) {

        return staffMapper.getStaffById(staffId);
    }

    /**
     * 添加员工信息
     *
     * @param staff 员工实体类
     * @return
     */
    @Override
    public int addStaff(Staff staff) {
        int result = staffMapper.addStaff(staff);

        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * 修改员工信息
     *
     * @param staff 员工实体类
     * @return
     */
    @Override
    public int updateStaff(Staff staff) {

        int result = staffMapper.updateStaff(staff);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * 删除员工信息
     *
     * @param staff_id 员工id
     * @return
     */
    @Override
    public int deleteStaff(long staff_id) {
        int result = staffMapper.deleteById(staff_id);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 查询所有员工信息
     *
     * @return
     */
    @Override
    public List<Staff> findAllStaff() {

        List<Staff> findAllStaff = staffMapper.selectAll();
        return findAllStaff;
    }
}
