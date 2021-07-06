package com.demo.service.impl;

import com.demo.dao.CustomerMapper;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 涂德东
 * Date on 2021/7/2  16:26
 * JavaVersion 1.8
 * @Description
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public int addCustomerByUser() {


        int res = customerMapper.addCustomerByUser();

        if (res >= 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
