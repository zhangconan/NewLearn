package com.zkn.newlearn.opensource.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Created by wb-zhangkenan on 2017/5/25.
 *
 * @author wb-zhangkenan
 * @date 2017/05/25
 */
public class LearnParserExcel {

    public static void main(String[] args) {
        //日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\LearnVideo\\test.xls");
            //创建工作画布
            Workbook wb = WorkbookFactory.create(fis);
            //获取第一个sheet页
            Sheet sheet = wb.getSheetAt(0);
            //获取总行数
            int rowNum = sheet.getLastRowNum();
            //列数
            int cellNum = 5;
            Row row = null;
            Cell cell = null;
            for (int i = 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < 5; j++) {
                    cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    System.out.println("日期为：" + sdf.format(cell.getDateCellValue()));
                                } else {
                                    System.out.println("钱币：" + cell.getNumericCellValue()+"");
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.println("字符类型" + cell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                    }
                }
                /*
                //获取相应的行
                row = sheet.getRow(i);
                cell = row.getCell(0);
                Double value = cell.getNumericCellValue()*100;
                BigDecimal decimal = new BigDecimal(cell.getNumericCellValue()+"");
                decimal.multiply(new BigDecimal("100"));
                decimal.longValue();
                System.out.println(value.longValue());
                */
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

