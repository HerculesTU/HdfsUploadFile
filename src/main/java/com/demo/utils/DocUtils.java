package com.demo.utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.util.*;

/**
 * @Author 涂德东
 * Date on 2021/7/5  15:23
 * JavaVersion 1.8
 * @Description POI替换指定模板中的word数据
 */
public class DocUtils {

    /**
     * <br>
     * poi 读取模版内容，替换模版内的文字
     * <br/>
     *
     * @param srcPath  模板地址
     * @param destPath 替换后目标地址
     * @param map      替换属性集合   例：  map.put("${title}", "POI word export");
     */
    public static void searchAndReplace(String srcPath, String destPath, Map<String, String> map) {
        FileOutputStream outStream = null;
        try {
            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(srcPath));
            /**
             * 替换段落中的指定文字
             */
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    List<XWPFRun> run = paragraph.getRuns();
                    for (int i = 0; i < run.size(); i++) {
                        if (run.get(i).getText(run.get(i).getTextPosition()) != null &&
                                run.get(i).getText(run.get(i).getTextPosition()).equals(key)) {
                            /**
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原来的文字全部替换掉了
                             */
                            run.get(i).setText(map.get(key), 0);
                        }
                    }
                }
            }

            /**
             * 替换表格中的指定文字
             */
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = (XWPFTable) itTable.next();
                int count = table.getNumberOfRows();
                for (int i = 0; i < count; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        for (Map.Entry<String, String> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {
                                cell.removeParagraph(0);
                                cell.setText(e.getValue());
                            }
                        }
                    }
                }
            }
            outStream = new FileOutputStream(destPath);
            document.write(outStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outStream);
        }

    }


}
