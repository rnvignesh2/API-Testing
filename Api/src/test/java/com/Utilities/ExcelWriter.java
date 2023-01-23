package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	
	public void writeExcel(String idValue) throws Exception {
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\GET DATA TemplateIds.xlsx");
		FileInputStream stream=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("Get Datas");
		
		Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
		Cell cc = row.createCell(0);
		cc.setCellValue(idValue);
		
		FileOutputStream fo=new FileOutputStream(f);
		w.write(fo);
		w.close();
		
	}
	
	public void putWriteExcel(String idValue) throws Exception {
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\PUT DATA.xlsx");
		FileInputStream stream=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("five Datas");
		Row row = sheet.getRow(0);
		Cell cc = row.createCell(1);
		cc.setCellValue(idValue);
		Row row1 = sheet.getRow(1);
		Cell cc1 = row1.createCell(1);
		cc1.setCellValue(idValue);
		Row row2 = sheet.getRow(2);
		Cell cc2 = row2.createCell(1);
		cc2.setCellValue(idValue);
		Row row3 = sheet.getRow(3);
		Cell cc3 = row3.createCell(1);
		cc3.setCellValue(idValue);
		Row row4 = sheet.getRow(4);
		Cell cc4 = row4.createCell(1);
		cc4.setCellValue(idValue);
		FileOutputStream fo=new FileOutputStream(f);
		w.write(fo);
		w.close();
}
	
	public void putTemplateIdExcel(String idValue) throws Exception {
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\PUT DATA.xlsx");
		FileInputStream stream=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("five Datas");
		Row row = sheet.getRow(0);
		Cell cc = row.createCell(7);
		cc.setCellValue(idValue);
		Row row1 = sheet.getRow(1);
		Cell cc1 = row1.createCell(7);
		cc1.setCellValue(idValue);
		Row row2 = sheet.getRow(2);
		Cell cc2 = row2.createCell(7);
		cc2.setCellValue(idValue);
		Row row3 = sheet.getRow(3);
		Cell cc3 = row3.createCell(7);
		cc3.setCellValue(idValue);
		Row row4 = sheet.getRow(4);
		Cell cc4 = row4.createCell(7);
		cc4.setCellValue(idValue);
		FileOutputStream fo=new FileOutputStream(f);
		w.write(fo);
		w.close();
}
}
