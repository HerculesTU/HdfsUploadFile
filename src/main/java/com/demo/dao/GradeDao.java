package com.demo.dao;

import com.demo.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Grade)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-03 17:09:16
 */
@Mapper
public interface GradeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 实例对象
     */
    Grade queryById(Integer classId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Grade> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param grade 实例对象
     * @return 对象列表
     */
    List<Grade> queryAll(Grade grade);

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 影响行数
     */
    int insert(Grade grade);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Grade> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Grade> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Grade> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Grade> entities);

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 影响行数
     */
    int update(Grade grade);

    /**
     * 通过主键删除数据
     *
     * @param classId 主键
     * @return 影响行数
     */
    int deleteById(Integer classId);

}

