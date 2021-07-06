package com.demo.document;
import org.apache.poi.xwpf.usermodel.*;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 涂德东
 * Date on 2021/7/5  9:05
 * JavaVersion 1.8
 * @Description 通过XWPFDocument将相应的数据写入到word文档
 */
public class WordWrite {

    public void TestWrite() throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("reportDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        params.put("appleAmt", "100.00");
        params.put("bananaAmt", "200.00");
        params.put("totalAmt", "300.00");

        //获取模板文件地址
        String filePath = "C:\\Users\\Administrator\\Desktop\\template.docx";
        //将文件转换为数据流
        InputStream is = new FileInputStream(filePath);

        //通过XWPFDocument转换文件
        XWPFDocument doc = new XWPFDocument(is);

        //替换段落里的变量
        this.replaceInPara(doc, params);
        //替换表格里的变量
        this.replaceInTable(doc, params);

        //将替换掉的数据写入到doc文档中
        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\write.docx");
        doc.write(os);
        this.closeStream(is,os);

    }


    /**
     * 替换段落中的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {

        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    /**
     * 替换段落中的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {

        List<XWPFRun> runs;
        Matcher matcher;

        if (this.matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();

            //循环获取段落中的内容
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = this.matcher(runText);
                if (matcher.find()) {
                    while ((matcher = this.matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }

                    para.removeRun(i);
                    para.insertNewRun(i).setText(runText);
                }


            }
        }


    }


    /**
     * 替换表格中的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {

        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }


    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    private Matcher matcher(String str) {

        Pattern pattern = Pattern.compile("\\$\\{(.*?)}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * 关闭流
     *
     * @param is 输入流
     * @param os 输出流
     */
    public void closeStream(InputStream is, OutputStream os) {

        if (is != null) {

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

