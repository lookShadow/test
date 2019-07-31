package com.cn.ouyjs.myProject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ouyjs
 * @date 2019/6/13 14:59
 */
public class ExportTestExcel {
    public static void main(String[] args) {
        ExportTestExcel exportTest = new ExportTestExcel();
        String path="C:\\me\\project\\com-cn-text\\demo.xlsx";
        try {
           // FileInputStream in = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook();
            creatExport(workbook);
            FileOutputStream out = new FileOutputStream(path);
            workbook.write(out);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void creatExport(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        createRow(sheet,10, workbook);
    }

    private static void createRow(Sheet sheet, int i,Workbook workbook) {
        sheet.setForceFormulaRecalculation(true);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("kkkkkkkk");
        row.setHeightInPoints(20);
        //第一行的样式
        Font redfont = workbook.createFont();
        redfont.setColor(IndexedColors.RED.getIndex());

        CellStyle commonCellStyle = workbook.createCellStyle();
        commonCellStyle.setAlignment(HorizontalAlignment.CENTER);
        commonCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        commonCellStyle.setWrapText(true);
        commonCellStyle.setFont(ExportTestExcel.createFont(workbook, (short) 9, false));
        commonCellStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());

        CellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.cloneStyleFrom(commonCellStyle);
        titleCellStyle.setFont(ExportTestExcel.createFont(workbook, (short) 14, true));


        cell.setCellStyle(titleCellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
        row = sheet.createRow(1);

        Cell cell1 = row.createCell(9);
        cell1.setCellFormula("SUM(B3+D3)");
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,8));
        for(int j = 2; j < i ;j ++) {
            row = sheet.createRow(j);
            createCell(row, 10);
        }
    }

    private static void createCell(Row row,int i) {
        for(int j = 0; j < i ;j ++) {
            Cell cell = row.createCell(j);
            cell.setCellValue(j);
        }
    }

    private static Font createFont(Workbook workbook, short fontSize, boolean needBold) {
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints(fontSize);
        if (needBold) {
            font.setBold(true);
        }
        return font;
    }

}
