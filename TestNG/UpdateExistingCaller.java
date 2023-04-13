package week5.TestNG;

import java.io.IOException;

//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;



public class UpdateExistingCaller extends CallerBaseClass {
	@Test(dataProvider="sendingdata")

	public void runUpdateExistingCaller(String name,String phno) throws InterruptedException {
	
        Shadow dom=new Shadow(driver);
        dom.setImplicitWait(25);
        dom.findElementByXPath("//div[text()='All']").click();      
        dom.setImplicitWait(5);
        dom.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
        dom.findElementByXPath("//span[text()='Callers']").click();
        WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys(name,Keys.ENTER);
        Thread.sleep(1500);
        driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[5]")).click();
        driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[5]")).sendKeys("",Keys.ENTER);
        Thread.sleep(1500);
       // dom.findElementByXPath("//input[@id='cell_edit_value']").click();
        
        WebElement findElement = dom.findElementByXPath("//input[@id='cell_edit_value']");
        driver.executeScript("arguments[0].click", findElement);     
        
        dom.findElementByXPath("//input[@id='cell_edit_value']").sendKeys(phno);
        dom.findElementByXPath("//a[@id='cell_edit_ok']").click();
        String text = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[5]")).getText();
        if(text.contains(phno))
        {
        	System.out.println("Business number got updated");
        }
        else
        {
        	System.out.println("Business number not updated");
        }
       
      
        
	}
	@DataProvider
	public String[][] sendingdata() throws IOException
	{
		String[][] values= new String[2][2];
		@SuppressWarnings("resource")
		XSSFWorkbook workBook=new XSSFWorkbook("./Data/update_callerpno_withname.xlsx");
		XSSFSheet sheet= workBook.getSheetAt(0);
		int row_count=sheet.getLastRowNum();
		int col_count=sheet.getRow(0).getLastCellNum();
		System.out.println("Rows Count :"+row_count+" column count :"+col_count);
		int k=0;
		for(int i=1;i<=row_count;i++)
		{
				k=i;
			for(int j=0;j<col_count;j++)
			{
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				values[k-1][j]=stringCellValue;
			}
		}
		
		
		
		return values;
	}
	/*public String[] sendingdata() throws IOException
	{	
	String[]  stringCellValue =new String[2];
	@SuppressWarnings("resource")
	XSSFWorkbook workbook =new XSSFWorkbook("./Data/caller_update.xlsx");
	
	XSSFSheet sheetno =workbook.getSheetAt(0);
	int row_count=sheetno.getLastRowNum();
	System.out.println("No Of rows: "+row_count);
	int col_count=sheetno.getRow(0).getLastCellNum();
	System.out.println("NO of columns :"+col_count);
	int k=0;
	XSSFCell cell=sheetno.getRow(1).getCell(0);
	XSSFCell cell1=sheetno.getRow(2).getCell(0);
	System.out.println(cell+"----"+cell1);
	for(int i=1;i<=row_count;i++) 
	{	
		k=i;
		System.out.println(i+"---"+row_count);
	for(int j=0;j<col_count;j++)
	{
		System.out.println(i+"---"+row_count+"--j--"+j+"---col count--"+col_count);
	  String text= sheetno.getRow(i).getCell(j).getStringCellValue();	 
	  stringCellValue[k-1]=text; 
	System.out.println(text+"------"+stringCellValue);		
	
	}
	}
	return stringCellValue;				
		
	}
*/	
}

	
	
	


