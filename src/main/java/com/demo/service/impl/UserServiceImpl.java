package com.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 涂德东
 * Date on 2021/7/1  9:12
 * JavaVersion 1.8
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 根據id查詢用戶信息
     * @param uid
     * @return
     */
    @Override
    public User selectById(Integer uid) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public String deleteById(Integer uid) {
        return null;
    }

    @Override
    public String updateById(Integer uid) {
        return null;
    }

    @Override
    public String addUser(User user) {
        return null;
    }

    @Override
    public User loginUserByTel(String tel, String pwd) {

        return userMapper.loginUserByTel(tel,pwd);
    }

    /**
     * 获取user表全部信息
     * @return
     */
    @Override
    public List<User> findAllUser() {

        return userMapper.getAllUser();

    }


    /**
     * 多条件分页查询用户
     * @param userParam 实体类字段
     * @param pageNum 页号
     * @param pageSize 页码
     * @return
     */
    @Override
    public PageInfo<User> queryByPage(User userParam, Integer pageNum, Integer pageSize) {


        //进行分页查询
        PageHelper.startPage(pageNum,pageSize);

        List<User> userList =  userMapper.queryByPage(userParam);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        return pageInfo;
    }
}
