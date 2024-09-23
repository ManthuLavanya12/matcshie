package com.matschie.data.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata implements DataHandler {
	public  String[][] getData(String ExcelFileName){
		XSSFWorkbook workbook;
		String[][] data =null;
		try {
			workbook =new XSSFWorkbook("src/main/resources/data/"+ExcelFileName+".xlsx");
			XSSFSheet sheet=workbook.getSheetAt(0);
			int rowcount=sheet.getLastRowNum();
			int colcount= sheet.getRow(0).getLastCellNum();
			data= new String[rowcount][colcount];
			for(int i=1;i<=rowcount;i++) {
				for(int j=0;j<colcount;j++) {
					data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
	}

}
