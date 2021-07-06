package com.demo.task;

import com.demo.entity.Staff;
import com.demo.entity.User;
import com.demo.service.CustomerService;
import com.demo.service.StaffService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.transform.Source;
import java.util.List;

/**
 * @Author 涂德东
 * Date on 2021/7/1  17:42
 * JavaVersion 1.8
 * @Description 定时从表中获取数据传输到其他表中
 */
@Configuration
@EnableScheduling
public class GetTask {


    @Autowired
    private StaffService staffService;

    @Autowired
    private CustomerService customerService;


    /**
     * 每隔15秒触发一次
     */
    @Scheduled(cron = "*/15 * * * * *")
    public void getUserInfo() {

        try {

            staffService.addStaffByUSerFiled();
            customerService.addCustomerByUser();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}




