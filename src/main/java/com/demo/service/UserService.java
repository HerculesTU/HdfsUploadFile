package com.demo.service;

import com.demo.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.avro.data.Json;

import java.util.List;

/**
 * @Author 涂德东
 * Date on 2021/7/1  9:03
 * JavaVersion 1.8
 * @Description 用户的业务类接口
 */
public interface UserService {

    /**
     * 根据id查询所有信息
     * @return
     */
    User selectById(Integer uid);


    /**
     * 查詢所有
     * @return
     */
    List<User> selectAll();

    /**
     * 根據id進行刪除
     * @param uid
     * @return
     */
    String deleteById(Integer uid);

    /**
     * 根據id進行修改
     * @param uid
     * @return
     */
    String updateById(Integer uid);

    /**
     * 添加用戶信息
     * @param user
     * @return
     */
    String addUser(User user);


    /**
     * 根據密碼和電話進行查詢
     * @param pwd 密碼
     * @param tel 電話
     * @return
     */
    User loginUserByTel(String tel,String pwd);

    /**
     * 获取user表的全部数据
     * @return
     */
    List<User> findAllUser();


    /**
     * 多条件分页查询用户
     * @param userParam 实体类字段
     * @param pageNum 页号
     * @param pageSize 页码
     * @return
     */
    PageInfo<User> queryByPage(User userParam, Integer pageNum, Integer pageSize);



}
