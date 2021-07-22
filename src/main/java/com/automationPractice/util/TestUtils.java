package com.automationPractice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automationPractice.Base.TestBase;

public class TestUtils extends TestBase{

	public TestUtils() throws IOException {
		super();
	}

	
	public static Object[][] getDataFromExcel(String sheetName) throws Exception 
	{
		File file = new File("E:\\LinkDev\\Automation task\\Automation parctice data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cloumns = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rows][cloumns];
		System.out.println(sheet.getRow(0).getCell(1).toString());
		for(int i=1; i<= rows; i++)
		{
			for(int k=0; k< cloumns; k++)
			{
				//data[i-1][k] = sheet.getRow(i).getCell(k).toString();
				data[i-1][k] = new DataFormatter().formatCellValue(sheet.getRow(i).getCell(k)).toString();
			}
			
		}
		
		System.out.println(rows);
		return data;
	}
	
}
