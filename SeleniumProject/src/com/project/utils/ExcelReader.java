package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void ReadFromExcel(String filepath, String filename, String sheetname) throws IOException{
		//First point to the physical location of the file using File Object
		File file = new File(filepath + "/" + filename);
		//First open the file in Read mode
		FileInputStream inputStream = new FileInputStream(file);
		//Creating an instance workbook - Excel Workbook Object
		//We use XSSFWorkbook to read from xslx
		//We use HSSFWorkbook to read from xlx
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		//This returns number of non empty rows
		int rowCount = sheet.getLastRowNum();
		for(int r=0; r<=rowCount; r++){
			Row row = sheet.getRow(r);
			for(int c=0; c<row.getLastCellNum(); c++){
				Cell cell = row.getCell(c);
				System.out.print(cell.getStringCellValue().toString() + "\t");
			}
			System.out.println();
		}
	}
	
	public static Object[][] ReadFromExcelToObjArr(String filepath, String filename, String sheetname) throws IOException{
		File file = new File(filepath + "/" + filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum(); //2 data row an 1 header row - returns 2 as rowcount
		Object[][] data = new Object[rowCount][1];
		Hashtable<String, String> rec = null;
		Row keysrow = sheet.getRow(0);
		for(int r=1; r<=rowCount; r++){
			rec = new Hashtable<String, String>();
			Row datarow = sheet.getRow(r);
			for(int c=0; c<datarow.getLastCellNum(); c++){
				String key = keysrow.getCell(c).getStringCellValue();
				String val = datarow.getCell(c).getStringCellValue();
				rec.put(key, val);
			}
			data[r-1][0] = rec;
		}
		return data;
	}
	
	public static void main(String[] args) throws IOException{
		String ProjectPath = System.getProperty("user.dir");
		String FilePath = ProjectPath + "/src/com/project/testdata";
		String FileName = "CalorieTestData.xlsx";
		String SheetName = "CalorieTestSet";
		ExcelReader.ReadFromExcel(FilePath, FileName, SheetName);
	}

}
