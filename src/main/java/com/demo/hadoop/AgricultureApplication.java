package com.demo.hadoop;


import org.springframework.boot.SpringApplication;

/**
 * @功能 hadoop压缩包位置
 */

public class AgricultureApplication {

    public static void main(String[] args) {

        try {
            // 加载系统hadoop目录位置
            System.setProperty("hadoop.home.dir", "E:\\hadoop-2.10.1");

            // 手动加载hadoop.dll文件
            System.load("E:\\hadoop-2.10.1\\bin\\hadoop.dll");
        } catch (Exception e) {

            System.out.println("加载文件失败！");
        }

        SpringApplication.run(AgricultureApplication.class, args);
    }
}
