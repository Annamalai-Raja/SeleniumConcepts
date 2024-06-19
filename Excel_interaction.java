package com.selenium.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel_interaction {

	@DataProvider(name = "exceldata")
	public Object[][] exceldata() throws IOException {
		return getexcelData();

	}

	public Object[][] getexcelData() throws IOException {
		List<Object[]> data = new ArrayList<>();
		FileInputStream fis = new FileInputStream("E:\\Selenium\\practice\\src\\test\\resources\\demo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowiterator = sheet.iterator();
		rowiterator.next();
		while (rowiterator.hasNext()) {

			Row row = rowiterator.next();

			List<Object> celldata = new ArrayList<Object>();

			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case STRING:
					celldata.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					celldata.add(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					celldata.add(cell.getBooleanCellValue());
					break;

				default:
					celldata.add(null);
					break;
				}
			}
			fis.close();
			workbook.close();
			data.add(celldata.toArray());
		}
		
  return data.toArray(new Object[0][0]);
	}

	@Test(dataProvider = "exceldata")
	public void excel_interaction(String username, String password, double age) {
		System.out.println("Username is " + username);
		System.out.println("password is " + password);
		System.out.println("age is " + age);
	}
}
