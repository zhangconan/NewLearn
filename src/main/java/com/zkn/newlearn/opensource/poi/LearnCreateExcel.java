package com.zkn.newlearn.opensource.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;

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
        //设置下拉选
        DataValidationHelper helper = sheet01.getDataValidationHelper();
        CellRangeAddressList addressList = new CellRangeAddressList(1, 10, 4, 4);
        //设置下拉框数据
        String[] pos = { "3.75", "3.50", "3.25"};
        DataValidationConstraint constraint = helper.createExplicitListConstraint(pos);
        DataValidation dataValidation = helper.createValidation(constraint, addressList);
        //处理Excel兼容性问题
        if(dataValidation instanceof XSSFDataValidation) {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        }else {
            dataValidation.setSuppressDropDownArrow(false);
        }
        sheet01.addValidationData(dataValidation);
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
        cell01 = row01.createCell(4);
        cell01.setCellStyle(style);
        cell01.setCellValue("下拉选");
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
            cell.setCellValue("78555787454778" + i);

            cell = row.createCell(2);
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellStyle(moneyStyle);
            cell.setCellValue(random.nextLong()*0.1);

            cell = row.createCell(3);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(sdf.format(new Date(random.nextLong())));
        }
        //列宽度自适应 这个一定要放到最后
        sheet01.autoSizeColumn(0);
        sheet01.autoSizeColumn(1);
        sheet01.autoSizeColumn(2);
        sheet01.autoSizeColumn(3);
        sheet01.autoSizeColumn(4);
        FileOutputStream fou = null;
        try {
            fou = new FileOutputStream("D:\\LearnVideo\\test.xls");
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
