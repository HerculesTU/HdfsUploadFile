package com.demo.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@RequestMapping(value = "/hdfs")
public class uploadFileForHtml {

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException, IOException, InterruptedException {

        System.out.println("开始上传文件");

        //获取输入流
        // 转换为 MultipartHttpServletRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 通过表单中的参数名来接收文件流（可用 file.getInputStream() 来接收输入流）
        MultipartFile file = multipartRequest.getFile("file");
        System.out.println("上传的文件名称:" + file.getOriginalFilename());
        System.out.println("上传的文件大小:" + file.getSize());

        //获取输入流字节数组
        byte[] bytes = file.getBytes();

        //获取hdfs对象
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost:9000"), conf, "root");

        //获取输出流,并写入到hdfs
        FSDataOutputStream fos = hdfs.create(new Path("/home/Data/hdfs"));
        fos.write(bytes,0,bytes.length);

        //关流
        IOUtils.closeStream(fos);
        hdfs.close();
        System.out.println("OVER");

    }

}
