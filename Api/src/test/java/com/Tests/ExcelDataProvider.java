package com.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	@Test
	private Object[][] excelReader() throws Exception {
		// TODO Auto-generated method stub

	File f=new File("C:\\Users\\Singa\\Desktop\\datas.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("vicky");
	Row row2 = sheet.getRow(0);
	int cells = row2.getPhysicalNumberOfCells();

	Object[][] S =new Object[sheet.getPhysicalNumberOfRows()][cells];
	 
	for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		
		Row row = sheet.getRow(i);
		
		for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
			
			Cell cell = row.getCell(j);
			DataFormatter d=new DataFormatter();
			String value = d.formatCellValue(cell);
			
			 S[i][j]= value;
			 System.out.println(S[i][j]);
		}	
	}
	return S;
		
		}
}
