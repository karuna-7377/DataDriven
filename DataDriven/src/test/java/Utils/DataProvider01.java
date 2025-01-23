package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvider01 {

@DataProvider(name="fbreg")
	
	///to store our data we are returning a 2 dimensional array as its always rows and columns
	public String [][] getData() throws IOException
	{
		String[][] data=null;  ///Assigning null value to string data initially
		
		FileInputStream file = new FileInputStream("./testdatapractice/FBTest.xslx");   ///fileInputStream is a class that expects a string name file path
	    XSSFWorkbook workbook = new XSSFWorkbook(file); ///Here we are passing the file into the workbook
	    XSSFSheet sheet =workbook.getSheetAt(0);
	    
	    ////Now we are trying to get the number of rows and number of columns
	    int rowCount = sheet.getLastRowNum();
	    int columnCount = sheet.getRow(0).getLastCellNum();
	    
	    data = new String[rowCount][columnCount];   //here we are returning the count
	    ///Nested for loop ,where 1st for loop is for row count that is the parent For loop and secod for loop is for column for loop
	   ///row count i starts from 1 as 1st row is header which is not counted
	    for(int i = 1;i<=rowCount;i++) {
	    	XSSFRow row = sheet.getRow(i);  ///getRow is returning an XSSF row so we are storing in XSSFrow and we are giving the variable name as row
	    	///column values j start from 0 itself
	    	for(int j=0;j<=columnCount;j++) {
	    		String cellData = row.getCell(j).getStringCellValue(); ///cellData is the variable ,getstringCellValue() is a method that returns particular column data
	    		data[i-1][j] = cellData;
	    		
	    	}
	    	
	    }
	    
		return data;
		
	}
	
   @DataProvider(name="irctcreg")   
	public String[][] getIrctcData() throws IOException{
		String[][] data = null;
		
		FileInputStream file  = new FileInputStream("./testdatapractice.IRCTCTest.xlxs./");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//getting no . of rows and no. of columns
		int rowCount= sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		
		data = new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row =sheet.getRow(i);
			for(int j=0;j<=columnCount;j++) {
				////getStringcellvalue is the method that returns the value of the particular cell
				String cellData = row.getCell(j).getStringCellValue(); /// Eg: row is 1 , so it goes into 1st row , get cell(j) means gets into cell 0(column 0) for row 1 and getstringcellvalue means it returns that value  cell  
				 data[i-1][j] = cellData;	///data is assigned	 
			}
		}	
		return data;	
	}
   
   @DataProvider(name="Practicetestlogin")
	   
   public String[][] getTestData() throws Exception {
	   
	   String[][] data =null;
	   
	   FileInputStream file = new FileInputStream("./testdatapractice.name.xlsx.numbers/'");
	   
	   XSSFWorkbook workbook = new XSSFWorkbook(file);
	   XSSFSheet sheet = workbook.getSheetAt(0);
	   
	   int rowCount=sheet.getLastRowNum();
	   int columnCount = sheet.getRow(0).getLastCellNum();
	   
	   data = new String [rowCount][columnCount];
	   
	   for (int i=1;i<=rowCount;i++) {
		   XSSFRow row=sheet.getRow(i);
		   for(int j=0;j<=columnCount;j++) {
			   String cellData = row.getCell(j).getStringCellValue();
			   data [i-1][j] = cellData;
		   }
		   
	   }   
	return data;
	   
   }
}

