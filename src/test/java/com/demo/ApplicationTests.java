package com.demo;

import com.demo.document.WordWrite;
import com.demo.utils.DocUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }


    /**
     * POI替换指定模板中的word数据测试
     */
    @Test
    void WordWriteToDocTest() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("${reportDate}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        map.put("${appleAmt}", "100.00");
        map.put("${bananaAmt}", "200.00");
        map.put("${totalAmt}", "300.00");

        // 文件位置
        String srcPath = "C:\\Users\\Administrator\\Desktop\\template.docx";
        String destPath = "C:\\Users\\Administrator\\Desktop\\write.docx";
        DocUtils.searchAndReplace(srcPath, destPath, map);
    }

    @Test
    void WordWriteToDoc() throws Exception {

        WordWrite wordWrite = new WordWrite();
        wordWrite.TestWrite();

    }

}
