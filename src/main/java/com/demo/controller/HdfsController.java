package com.demo.controller;


import com.demo.utils.HdfsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * @功能 HDFS接口
 */
@RestController
@RequestMapping(value = "/hdfs")
public class HdfsController {


    @Autowired
    private HdfsUtils hdfsUtils;


    /**
     * @功能 测试HDFS配置文件注入是否有效
     */

    @GetMapping(value = "/configTest")
    public void HdfsConfigTest() {

        hdfsUtils.test1();

    }

    /**
     * @功能 hdfs 创建目录
     * @测试用例 ----
     * @dir: aaa
     */
    @PostMapping(value = "/mkdir")
    public void HdfsMkdir(@RequestParam("dir") String path) throws Exception {

        hdfsUtils.mkdir(path);
    }

    /**
     * @功能 在HDFS创建文件，并向文件填充内容
     * @测试用例：---- filePath:aaa/a.txt
     * content:Hello Word
     */
    @PostMapping("/vim")
    public void HdfsVim(@RequestParam("filePath") String filePath,
                        @RequestParam(value = "content", required = false, defaultValue = "") String content)
            throws Exception {

        hdfsUtils.createFile(filePath, content.getBytes());
    }

    /**
     * @功能 读取HDFS文件内容，cat
     * <p>
     * 测试用例----
     * filepath: aaa/a.text
     */
    @GetMapping("/cat")
    public void HdfsCat(@RequestParam("filePath") String filePath) throws Exception {

        hdfsUtils.readFile(filePath);
    }

    /**
     * @功能 显示HDFS目录详细信息(包括目录下文件和子目录)
     * <p>
     * 测试用例----
     * filepath: aaa
     */
    @GetMapping("/catDir")
    public void HdfsFileCat(@RequestParam("filePath") String filePath) throws Exception {

        hdfsUtils.pathInfo(filePath);

    }

    /**
     * @功能 读取hdfs 指定目录下的文件列表
     * <p>
     * 测试用例----
     * filepath: aaa
     */
    @GetMapping("/ls")
    public void HdfsLs(@RequestParam("filePath") String filePath) throws Exception {

        hdfsUtils.listFile(filePath);
    }

    /**
     * @功能 文件重命名
     * <p>
     * 测试用例----
     * <p>
     * oldName：aaa/b.txt
     * newName: aaa/c.txt
     */
    @PostMapping("/renameFile")
    public void HdfsRenameFile(@RequestParam("oldName") String oldName,
                               @RequestParam("newName") String newName) throws Exception {

        hdfsUtils.renameFile(oldName, newName);
    }

    /**
     * @功能 删除指定文件
     * <p>
     * filePath: aaa/c.txt
     */
    @GetMapping("/deleteFile")
    public void HdfsDeleteFile(@RequestParam("filePath") String filePath) throws Exception {

        hdfsUtils.deleteFile(filePath);
    }

    /**
     * @功能 文件上传
     * <p>
     * 测试用例----
     * fileName: C:\Users\Administrator\Desktop\hello.txt
     * uploadFile: aaa
     */
    @PostMapping("/uploadFile")
    public void UploadFile(@RequestParam("fileName") MultipartFile fileName,
                           @RequestParam("uploadFile") String uploadFile) throws Exception {


        hdfsUtils.uploadFile(fileName, uploadFile);
    }


    /**
     * @功能 文件下载
     * <p>
     * 测试用例----
     * fileName:aaa/hello.txt
     * downPath:C:\Users\Administrator\Desktop
     */
    @PostMapping("/downloadFile")
    public void DownloadFile(@RequestParam("fileName") String fileName,
                             @RequestParam("downPath") String downPath) throws Exception {

        hdfsUtils.downloadFile(fileName, downPath);
    }

    /**
     * @功能 判断文件是否存在
     * <p>
     * 测试用例----
     */
    @PostMapping("/existFile")
    public void ExistFile(@RequestParam("fileName") String fileName) throws Exception {

        hdfsUtils.existFile(fileName);

    }

    /**
     * @功能 获取HDFS集群上所有节点名称信息
     */
    @RequestMapping(value = "/getListNode",method = RequestMethod.GET)
    public void HdfsGetListNode() throws Exception {

        hdfsUtils.getListNode();
    }

}
