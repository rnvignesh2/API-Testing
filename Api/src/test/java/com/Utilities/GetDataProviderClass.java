package com.Utilities;

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

public class GetDataProviderClass {

	
	@DataProvider
	public String[][] getExcelDataProvider() throws IOException {
		File f=new File("C:\\Users\\Singa\\Desktop\\POST Request\\GET DATA TemplateIds.xlsx");
		FileInputStream stream=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("Get Datas");
		Row row2 = sheet.getRow(0);
		int cells = row2.getPhysicalNumberOfCells();
		int rows = sheet.getPhysicalNumberOfRows();

		String[][] S =new String[rows][cells];
		String cellData[][] = new String[rows][cells];
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < 1; j++) {
				try {
				Cell cell = row.getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			DataFormatter d=new DataFormatter();
			String value = d.formatCellValue(cell);
				
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
