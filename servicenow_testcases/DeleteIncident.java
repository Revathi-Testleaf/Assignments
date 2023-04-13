package servicenow_testcases;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteIncident extends Connections {
	@Test(dataProvider = "sendingdata")
	public void runDeleteIncident(String inc_no) throws InterruptedException {
		/*
		 * 1. Launch ServiceNow application 2. Login with valid credentials 3. Enter
		 * Incident in filter navigator and press enter" 4. Search for the existing
		 * incident and navigate into the incident 5. Delete the incident 6. Verify the
		 * deleted incident
		 */Shadow dom = new Shadow(driver);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(3);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		dom.findElementByXPath("//span[text()='Incidents']").click();
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		Select sec1=new Select(driver.findElement(By.xpath("//select[contains(@class,'form-control default-focus-outline')]")));
		sec1.selectByVisibleText("Number");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys(inc_no,Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td/a[contains(@class,'linked formlink')]")).click();
		Thread.sleep(1500);
	/**	Select sec=new Select(driver.findElement(By.xpath("//select[contains(@class,'list_action_option form-control')]")));
        sec.selectByVisibleText("Delete");
	WebElement findElement2 = driver.findElement(By.xpath("//select[contains(@class,'list_action_option')]"));
		driver.executeScript("arguments[0].click()", findElement2);
		WebElement findElement = driver.findElement(By.xpath("//select[contains(@class,'list_action_option')]"));
		Select sec=new Select(findElement);
		sec.selectByVisibleText("Delete");**/
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//tbody[@class='list2_body']/tr/td/a[contains(@class,'linked formlink')]"));
		int size = findElements.size();
		System.out.println("size of list : "+size);
		if(size==0)
		{
			System.out.println("Record got deleted :"+inc_no);
		}
		else
		{
		System.out.println("Record not deleted: "+inc_no);	
		}
		
		
	}
	
	
@DataProvider
	public String[] sendingdata() throws IOException {
		String[] data = new String[2];
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook("./Data/DeleteIncident.xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		int row_no = sheet.getLastRowNum();
		int col_no = sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count : " + row_no + " Column no :" + col_no);
		int k = 0;
		for (int i = 1; i <= row_no; i++) {
			k = i;
			String values = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(values);
			data[k - 1] = values;
		}

		return data;

	}

}
