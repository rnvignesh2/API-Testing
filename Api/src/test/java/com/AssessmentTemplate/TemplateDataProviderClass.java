package com.AssessmentTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.Utilities.ExcelWriter;

public class TemplateDataProviderClass extends ExcelWriter{

	@DataProvider
	public Object[][] postExcelDataProvider4() throws IOException {
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA - AssessmentTemplate.xlsx");
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
				
//				 S[i][j]= value;
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
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA - AssessmentTemplate.xlsx");
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
				
//				 S[i][j]= value;
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
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA - AssessmentTemplate.xlsx");
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
				
//				 S[i][j]= value;
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
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\POST DATA - AssessmentTemplate.xlsx");
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
				
//				 S[i][j]= value;
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
	
}
