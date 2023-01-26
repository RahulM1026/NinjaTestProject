package com.ninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int Implict_Time=10;
	public static final int Load_Time=5;

	public static String GenerateStamp() {

		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");

	}
	
	public static String GenerateEmail() {
		
		return "rahul"+Utilities.GenerateStamp()+"@gmail.com";
	}

	
	public static Object[][] GetTestData(String Sheetname) {
		
		File ExcelFile = new File(System.getProperty("user.dir")+"//src//main//java//com//ninja//qa//testdata//NinjaTestdata.xlsx");
		XSSFWorkbook workbook=null;
		try {
			FileInputStream fis = new FileInputStream(ExcelFile);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("Login");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int r=0;r<rows;r++) {
			XSSFRow row = sheet.getRow(r+1);
			
			for(int c=0;c<cols;c++) {
				XSSFCell cell = row.getCell(c);
				CellType cellType=cell.getCellType();
				
				switch(cellType) {
				case STRING:
					data[r][c]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[r][c]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[r][c]=cell.getBooleanCellValue();
				default:
					break;
				
				}
			}
		}
		return data;
	}
	
		public static  String CaptureScreenShot(WebDriver driver,String TestName) {
			
			File SrcShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String DstPath = System.getProperty("user.dir")+ "\\ScreenShots\\"+TestName+Utilities.GenerateStamp()+".png";
			
			try {
				FileHandler.copy(SrcShot,new File(DstPath));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return DstPath;
		}
	
}
