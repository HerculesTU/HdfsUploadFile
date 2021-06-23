package com.demo.utils;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URI;

/**
 * HDFS工具类
 */
@Component
public class HdfsUtils {

    // HDFS上传服务器地址
    @Value("${hdfs.host}")
    private String hdfsPath;

    // HDFS上传路径
    @Value("${hdfs.uploadPath}")
    private String userPath;


    // 测试类
    public void test1() {
        System.out.println(hdfsPath);
        System.out.println(userPath);
    }


    /**
     * @return 配置信息
     * @功能 获取HDFS配置信息
     */

    private Configuration getHdfsConfig() {

        Configuration config = new Configuration();

        return config;
    }

    /**
     * @功能 获取FS对象
     */

    private FileSystem getFileSystem() throws Exception {

        FileSystem hdfs = FileSystem.get(new URI(hdfsPath), getHdfsConfig(), "hadoop");

        return hdfs;

    }

    /**
     * @功能 递归创建目录
     */

    public void mkdir(String path) throws Exception {

        FileSystem fileSystem = getFileSystem();

        Path srcPath = new Path(path);

        boolean isOk = fileSystem.mkdirs(srcPath);

        if (isOk) {
            System.out.println("文件目录创建成功！");
        } else {
            System.out.println("文件目录创建失败！");
        }

        fileSystem.close();
    }

    /**
     * @功能 在HDFS创建文件，并向文件填充内容
     */
    public void createFile(String filePath, byte[] files) {

        try {
            FileSystem fileSystem = getFileSystem();

            // 目标路径
            Path path = new Path(filePath);

            // 打开一个输出流
            FSDataOutputStream outputStream = fileSystem.create(path);

            // 向文件中填充内容
            outputStream.write(files);

            // 关闭流操作
            fileSystem.close();
            outputStream.close();

            System.out.println("创建文件成功！");


        } catch (Exception e) {

            System.out.println("创建文件失败！");
        }

    }

    /**
     * @功能 读取HDFS文件内容
     */

    public void readFile(String filePath) throws Exception {

        FileSystem fileSystem = getFileSystem();

        Path path = new Path(filePath);

        InputStream in = null;

        try {
            in = fileSystem.open(path);

            // 复制到标准输出流
            IOUtils.copyBytes(in, System.out, 4096, false);

            System.out.println("\\n读取文件成功！");

        } catch (Exception e) {
            System.out.println("\\n读取文件失败！");
        } finally {
            IOUtils.closeStream(in);
        }
    }

    /**
     * @功能 读取HDFS目录详细信息
     */

    public void pathInfo(String filePath) throws Exception {

        FileSystem fileSystem = getFileSystem();

        FileStatus[] listStatus = fileSystem.listStatus(new Path(filePath));

        // 循环输出目录详细信息
        for (FileStatus fileStatus : listStatus) {
            System.out.println(fileStatus.getPath() + ">>>>>>" + fileStatus.toString());

        }

    }

    /**
     * @功能 读取HDFS文件列表
     */

    public void listFile(String filePath) throws Exception {

        FileSystem fileSystem = getFileSystem();

        // 递归找到所有的文件列表
        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path(filePath), true);

        while (listFiles.hasNext()) {

            LocatedFileStatus next = listFiles.next();

            String name = next.getPath().getName();

            Path path = next.getPath();

            System.out.println(name + "----->" + path);


        }

    }

    /**
     * @功能 文件重命名
     */
    public void renameFile(String oldName, String newName) throws Exception {

        FileSystem fileSystem = getFileSystem();

        Path oldPath = new Path(oldName);
        Path newPath = new Path(newName);

        boolean isOk = fileSystem.rename(oldPath, newPath);

        if (isOk) {

            System.out.println("文件重命名成功！");

        } else {
            System.out.println("文件重命名失败！");
        }

        fileSystem.close();
    }

    /**
     * @功能 删除指定文件
     */
    public void deleteFile(String filePath) throws Exception {

        FileSystem fileSystem = getFileSystem();

        Path path = new Path(filePath);


        boolean isOk = fileSystem.deleteOnExit(path);

        if (isOk) {
            System.out.println("文件删除成功！");
        } else {
            System.out.println("文件删除失败！");
        }
        fileSystem.close();
    }


    /**
     * @功能 上传文件
     */
    public void uploadFile(String fileName, String uploadPath) throws Exception {

        FileSystem fileSystem = getFileSystem();

        // 上传路径
        Path clientPath = new Path(fileName);

        // 目标路径
        Path serverPath = new Path(uploadPath);

        // 调用文件系统的文件复制方法,前面参数是指是否删除原文件，true为删除，默认为false
        fileSystem.copyFromLocalFile(clientPath, serverPath);

        fileSystem.close();

        System.out.println("文件上传成功！");
    }

    /**
     * @功能 下载文件
     */
    public void downloadFile(String fileName, String downPath) throws Exception {

        FileSystem fileSystem = getFileSystem();

        fileSystem.copyToLocalFile(new Path(fileName), new Path(downPath));

        fileSystem.close();

        System.out.println("文件下载成功！");

    }

    /**
     * @功能 判断文件是否存在
     */
    public boolean existFile(String fileName) throws Exception {

        FileSystem fileSystem = getFileSystem();

        Path path = new Path(fileName);

        boolean isExists = fileSystem.exists(path);

        return isExists;
    }

}

