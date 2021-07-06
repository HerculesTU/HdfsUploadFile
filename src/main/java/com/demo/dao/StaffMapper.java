package com.demo.dao;

import com.demo.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {

    /**
     * 根据员工id查询所有员工信息
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
     int deleteById(long staffId);
    /**
     * 查询所有员工信息
     */
     List<Staff> selectAll();

    /**
     * 根据字段属性进行添加
     * @param name
     * @return
     */
     int addStaffByFiled(String name);

    /**
     * 将user表中的字段添加到staff表中
     * @return
     */
     int addStaffByUSerFiled();

}