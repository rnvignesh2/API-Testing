package com.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupplier{

	
	@DataProvider
	public Object[][] postDataSupplier() {

		Object[][] data=new Object[][] {
				{"dat3","data3",},
				{"dat4",56},
				{"da5t","dat5"},
		};
		return data;
//		List<String[]> li=new ArrayList();
//		li.add(new String[] {"vicky22","rn22"});
//		li.add(new String[] {"ram22","siva22"});
//		li.add(new String[] {"ram","siva"});
//		li.add(new String[] {"ram","siva"});
	//	return li.iterator();
	}

	@DataProvider
	public Object[] deleteDataSupplier() {
		
		Object[][] data=new Object[][] {
			{"ff739e11-09c3-4a09-8a74-cee3655d23ab"},
			{"ff739e11-09c3-4a09-8a74-cee3655d23ab"},
			{"ff739e11-09c3-4a09-8a74-cee3655d23ab"},};
	return data;

//		List<Object[]> li=new ArrayList();
//		li.add(new Object[] {"ff739e11-09c3-4a09-8a74-cee3655d23ab"});
//		li.add(new Object[] {"8b95149e-191c-4552-a25a-357d4d4ba1d1"});
//		li.add(new Object[] {"c2dd5ba2-3035-4f48-98f2-fc7d1fe53d10"});
//		li.add(new Object[] {"3dc749e8-0b49-4454-aa73-f25431355c7b"});
//		return li.iterator();
	}
	

	@DataProvider
	public Object[][] putDataSupplier() {
		Object[][] data=new Object[][] {
			{"logical","logica"},
			{"logicalre",23},
			{"logicalreasoning3","logicalanswer3"},};
	return data;
		
		
		
//		List<Object[]> li=new ArrayList();
//		li.add(new Object[] {"c9a556dc-8fea-4e1d-863c-870c8000c4a9","updated","updated2"});
		//li.add(new Object[] {"feb012ab-8c66-4323-a5ef-8609acc9cadd","updated3","updated3"});
//		li.add(new Object[] {""});
//		li.add(new Object[] {""});
//		return li.iterator();
	}

@DataProvider
public Object[][] postExcelDataProvider4() throws IOException {
	File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("four datas");
	Row row2 = sheet.getRow(0);
	int cells = row2.getPhysicalNumberOfCells();
	int rows = sheet.getPhysicalNumberOfRows();

	Object[][] S =new Object[rows][cells];
	Object cellData[][] = new Object[rows][cells];
	for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		
		Row row = sheet.getRow(i);
		
		for (int j = 0; j < 9; j++) {
			try {
			Cell cell = row.getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		DataFormatter d=new DataFormatter();
		Object value = d.formatCellValue(cell);
			
//			 S[i][j]= value;
			 try {
				 Cell value1 = row.getCell(j);
		}catch(NullPointerException nullpoint) {
			 cellData[i][j]="";
		}if (cell==null) {
			cellData[i][j]="";
		}else {
			
			cellData[i][j] =value;
		}

		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
			}
			
	}
	}
	return cellData;
		}

@DataProvider
public Object[][] postExcelDataProvider3() throws IOException {
	File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("three datas");
	Row row2 = sheet.getRow(0);
	int cells = row2.getPhysicalNumberOfCells();
	int rows = sheet.getPhysicalNumberOfRows();

	Object[][] S =new Object[rows][cells];
	Object cellData[][] = new Object[rows][cells];
	for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		
		Row row = sheet.getRow(i);
		
		for (int j = 0; j < 7; j++) {
			try {
			Cell cell = row.getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		DataFormatter d=new DataFormatter();
		Object value = d.formatCellValue(cell);
			
//			 S[i][j]= value;
			 try {
				 Cell value1 = row.getCell(j);
		}catch(NullPointerException nullpoint) {
			 cellData[i][j]="";
		}if (cell==null) {
			cellData[i][j]="";
		}else {
			
			cellData[i][j] =value;
		}

		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
			}
			
	}
	}
	return cellData;
		}

@DataProvider
public Object[][] postExcelDataProvider2() throws IOException {
	File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("two datas");
	Row row2 = sheet.getRow(0);
	int cells = row2.getPhysicalNumberOfCells();
	int rows = sheet.getPhysicalNumberOfRows();

	Object[][] S =new Object[rows][cells];
	Object cellData[][] = new Object[rows][cells];
	for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		
		Row row = sheet.getRow(i);
		
		for (int j = 0; j < 5; j++) {
			try {
			Cell cell = row.getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		DataFormatter d=new DataFormatter();
		Object value = d.formatCellValue(cell);
			
//			 S[i][j]= value;
			 try {
				 Cell value1 = row.getCell(j);
		}catch(NullPointerException nullpoint) {
			 cellData[i][j]="";
		}if (cell==null) {
			cellData[i][j]="";
		}else {
			
			cellData[i][j] =value;
		}

		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
			}
			
	}
	}
	return cellData;
		}

@DataProvider
public Object[][] postExcelDataProvider1() throws IOException {
	File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("one data");
	Row row2 = sheet.getRow(0);
	int cells = row2.getPhysicalNumberOfCells();
	int rows = sheet.getPhysicalNumberOfRows();

	Object[][] S =new Object[rows][cells];
	Object cellData[][] = new Object[rows][cells];
	for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		
		Row row = sheet.getRow(i);
		
		for (int j = 0; j < 3; j++) {
			try {
			Cell cell = row.getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		DataFormatter d=new DataFormatter();
		Object value = d.formatCellValue(cell);
			
//			 S[i][j]= value;
			 try {
				 Cell value1 = row.getCell(j);
		}catch(NullPointerException nullpoint) {
			 cellData[i][j]="";
		}if (cell==null) {
			cellData[i][j]="";
		}else {
			
			cellData[i][j] =value;
		}

		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
			}
			
	}
	}
	return cellData;
		}
//public static void main(String[] args) throws Exception {
//	DataProviderClass c=new DataProviderClass();
//	c.postExcelDataProvider();
//}

public void writeExcel(String idValue) throws Exception {
	File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("Sheet1");
	Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
	Cell cc = row.createCell(0);
	cc.setCellValue(idValue);
	FileOutputStream fo=new FileOutputStream(f);
	w.write(fo);
	
}
	
	}