package com.dataProviderDemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataFromExcelFile {

	String loginDataxlPath = "./dataFile/BookData.xlsx";

	public String[][] getExcelData(String loginDataxlPath, String sheetName) throws IOException {

		File file = new File(loginDataxlPath);
		FileInputStream fis;

		fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet(sheetName);
		int row = s.getPhysicalNumberOfRows();
		int col = s.getRow(0).getLastCellNum();
		String[][] data = new String[row - 1][col];

		for (int i = 0; i < row - 1; i++) {

			for (int j = 0; j < col; j++) {

				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(s.getRow(i + 1).getCell(j));

			}
			System.out.println();
		}

		wb.close();
		fis.close();

		return data;

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws Exception {
		Object[][] retObjArr = getExcelData(loginDataxlPath, "Sheet1");
		System.out.println("getData function executed!!");
		return retObjArr;
	}
	
	@DataProvider(name = "forgetPasswordData")
	public Object[][] getRegistrationData() throws IOException{
		
		Object[][] forgetPassObjArr = getExcelData(loginDataxlPath, "Sheet3");
		System.out.println("Forget Password data executed");
		return forgetPassObjArr;
		
		
		
	}

}
