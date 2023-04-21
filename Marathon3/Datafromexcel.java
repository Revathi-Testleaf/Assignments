package Marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datafromexcel {
		@DataProvider
		public static String[][] datafromexcel(String ExcelFileName) throws IOException {
			
			@SuppressWarnings("resource")
			XSSFWorkbook worksheet = new XSSFWorkbook("./Data/"+ExcelFileName+".xlsx");
			XSSFSheet sheet = worksheet.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();
			int columncount = sheet.getRow(0).getLastCellNum();
			String[][] data = new String[rowcount][columncount];
			System.out.println("Row count :" + rowcount + " Column count :" + columncount);
			for (int i = 1; i <= rowcount; i++) {				
				for (int j = 0; j < columncount; j++)
				{					
					String values = sheet.getRow(i).getCell(j).getStringCellValue();					
					data[i - 1][j] = values;
				}
			}
			worksheet.close();
			return data;
		}

}
