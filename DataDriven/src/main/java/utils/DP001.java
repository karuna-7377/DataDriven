package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP001 {
	
	@DataProvider(name="fbreg")
	public String[][] getData() throws IOException
	{
		String[][] data = null;
		
		FileInputStream file = new FileInputStream("./testdata/FBTest.xlsx");		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet  = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		data = new String[rowCount][columnCount];
		
		for(int i = 1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);			
			for(int j=0;j<columnCount;j++)
			{
				String celldata = row.getCell(j).getStringCellValue();
				
				data[i-1][j] = celldata;
				
			}
		}
		
		return data;
	}
	
	@DataProvider(name="irctcreg")
	public String[][] getIrctcData() throws IOException
	{
		String[][] data = null;
		
		FileInputStream file = new FileInputStream("./testdata/IRCRCTest.xlsx");		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet  = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		data = new String[rowCount][columnCount];
		
		for(int i = 1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);			
			for(int j=0;j<columnCount;j++)
			{
				String celldata = row.getCell(j).getStringCellValue();
				
				data[i-1][j] = celldata;
				
			}
		}
		
		return data;
	}

}
