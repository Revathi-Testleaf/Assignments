package week5.TestNG;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;
import org.testng.util.Strings;

public class DatafromExtentalfile {
	
	public static void main(Strings[] args) throws IOException 
	{
		String[][]  stringCellValue = new String[2][1];
		@SuppressWarnings("resource")
		XSSFWorkbook workbook =new XSSFWorkbook("./Data/caller_update.xlsx");
		
		XSSFSheet sheetno =workbook.getSheetAt(0);
		int row_count=sheetno.getLastRowNum();
		System.out.println("No Of rows: "+row_count);
		int column_count=sheetno.getRow(0).getLastCellNum();
		System.out.println("NO of columns :"+column_count);
		for(int i=1;i<=row_count;i++) 
		{			
		  stringCellValue[i][0] = sheetno.getRow(i).getCell(0).getStringCellValue();
			System.out.println(stringCellValue);		
		
		}
		//return stringCellValue;		
	}

}