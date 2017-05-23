package com.zkn.newlearn.opensource.poi;

import org.apache.poi.hssf.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by zkn on 2017/5/23.
 */
public class LearnCreateExcel {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Random random = new Random();
        //先创建一个画布
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建一些样式
        HSSFCellStyle style = wb.createCellStyle();
        //居中格式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //时间格式
        HSSFCellStyle dateStyle = wb.createCellStyle();
        HSSFDataFormat dateFormat = wb.createDataFormat();
        dateStyle.setDataFormat(dateFormat.getFormat("yyyy-MM-dd hh:mm:ss"));
        //钱币格式
        HSSFCellStyle moneyStyle = wb.createCellStyle();
        HSSFDataFormat moneyFormat = wb.createDataFormat();
        moneyStyle.setDataFormat(moneyFormat.getFormat("#,##0.00"));
        //创建一个sheet页
        HSSFSheet sheet01 = wb.createSheet();
        wb.setSheetName(0, "第一个sheet页");
        //创建行
        HSSFRow row01 = sheet01.createRow(0);
        //创建表头
        //第一个单元格
        HSSFCell cell01 = row01.createCell(0);
        cell01.setCellStyle(style);
        cell01.setCellValue("姓名");
        //第二个单元格
        cell01 = row01.createCell(1);
        cell01.setCellStyle(style);
        cell01.setCellValue("工号");
        //第三个单元格
        cell01 = row01.createCell(2);
        cell01.setCellStyle(style);
        cell01.setCellValue("收入");
        //第四个单元格
        cell01 = row01.createCell(3);
        cell01.setCellStyle(style);
        cell01.setCellValue("收入日期");
        HSSFRow row = null;
        HSSFCell cell = null;
        for (int i = 0; i < 10; i++) {
            //创建行
            row = sheet01.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellStyle(style);
            cell.setCellValue("张三" + i);

            cell = row.createCell(1);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellStyle(style);
            cell.setCellValue("78555" + i);

            cell = row.createCell(2);
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellStyle(moneyStyle);
            cell.setCellValue(random.nextLong()*0.1);

            cell = row.createCell(3);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(sdf.format(new Date(random.nextLong())));
        }
        FileOutputStream fou = null;
        try {
            fou = new FileOutputStream("G:\\LearnVideo\\test.xls");
            wb.write(fou);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fou != null){
                try {
                    fou.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
