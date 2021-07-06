package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据主键进行删除
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * 添加用户信息(所用字段都会添加)
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 添加用户信息(有值的字段才会添加)
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据主键进行查询
     * @param uid
     * @return
     */
    User selectByPrimaryKey(Integer uid);

    /**
     * 会对字段进行判断再更新(如果为Null就忽略更新)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 对注入的字段全部更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);


    /**
     * 根據密碼和電話查詢用戶信息
     * @param pwd
     * @param tel
     * @return
     */
    User loginUserByTel(String tel,String pwd);

    /**
     * 获取数据库的全部数据
     * @return
     */
    List<User> getAllUser();

    /**
     * 多条件分页查询
     * @param userParam
     * @return
     */
    List<User> queryByPage(User userParam);


}