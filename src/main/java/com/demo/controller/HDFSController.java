package com.demo.controller;


import com.demo.utils.HdfsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @功能 HDFS接口
 */
@RestController
public class HDFSController {


    @Autowired
    private HdfsUtils hdfsUtils;


    /**
     * @功能 测试HDFS配置文件注入是否有效
     */

    @GetMapping(value = "/hdfs/configTest")
    public void HdfsConfigTest() {

        hdfsUtils.test1();

    }

    /**
     * @功能 hdfs 创建目录
     *
     * @测试用例 ----
     */
    @PostMapping(value = "/hdfs/mkdir")
    public void HdfsMkdir(@RequestParam("dir") String path) throws Exception{

        hdfsUtils.mkdir(path);
    }

}
