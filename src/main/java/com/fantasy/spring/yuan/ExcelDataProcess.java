package com.fantasy.spring.yuan;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description:
 * @Author: wangbin
 * @Date: 2021/4/14 12:05
 */
public class ExcelDataProcess {

    private static final String DATA_COLUMN_NAME = "团支部名";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter File Path:");
        String filePath = sc.nextLine();  //读取字符串型输入
        Boolean isXls;
        if (filePath.matches("^.+\\.(?i)(xlsx)$")) {
            isXls = false;
        } else if (filePath.matches("^.+\\.(?i)(xls)$")) {
            isXls = true;
        } else {
            System.out.println("文件类型不正确");
            return;
        }
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        // 根据格式选择不一样的 workbook
        Workbook wb;
        if (isXls) {
            wb = new HSSFWorkbook(inputStream);
        } else {
            wb = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = wb.getSheetAt(0);
        Row row0 = sheet.getRow(0);
        //实际行数  getPhysicalNumberOfRows获取的是物理行数，不包括那些空行
        int actualRowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("预计处理数据 " + (actualRowCount - 1) + "条");
        //第一行所有列数
        int columnAll = row0.getPhysicalNumberOfCells();
        int dataColumnIndex = 0;
        if (columnAll > 0) {
            for (int i = 0; i < columnAll; i++) {
                if (DATA_COLUMN_NAME.equals(row0.getCell(i).getStringCellValue())) {
                    dataColumnIndex = i;
                    break;
                }
            }
        } else {
            System.err.println("列数小于1");
        }

        for (int i = 0; i < actualRowCount - 1; i++) {

        }

    }
}
