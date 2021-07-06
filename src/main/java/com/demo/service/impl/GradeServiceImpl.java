package com.demo.service.impl;

import com.demo.entity.Grade;
import com.demo.dao.GradeDao;
import com.demo.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Grade)表服务实现类
 *
 * @author makejava
 * @since 2021-07-03 17:09:18
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeDao gradeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 实例对象
     */
    @Override
    public Grade queryById(Integer classId) {
        return this.gradeDao.queryById(classId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Grade> queryAllByLimit(int offset, int limit) {
        return this.gradeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    @Override
    public Grade insert(Grade grade) {
        this.gradeDao.insert(grade);
        return grade;
    }

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    @Override
    public Grade update(Grade grade) {
        this.gradeDao.update(grade);
        return this.queryById(grade.getClassId());
    }

    /**
     * 通过主键删除数据
     *
     * @param classId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer classId) {
        return this.gradeDao.deleteById(classId) > 0;
    }
}
