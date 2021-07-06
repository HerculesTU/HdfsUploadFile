package com.demo.service;

import com.demo.entity.Grade;

import java.util.List;

/**
 * (Grade)表服务接口
 *
 * @author makejava
 * @since 2021-07-03 17:09:18
 */
public interface GradeService {

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 实例对象
     */
    Grade queryById(Integer classId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Grade> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    Grade insert(Grade grade);

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    Grade update(Grade grade);

    /**
     * 通过主键删除数据
     *
     * @param classId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer classId);

}
