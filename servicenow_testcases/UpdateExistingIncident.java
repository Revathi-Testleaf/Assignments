package servicenow_testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateExistingIncident extends Connections{
	@Test(dataProvider="sendingdata") 
	public  void runUpdateExistingIncident(String inc_no) {
		/*
		 * 1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Incident in filter navigator and press enter "
4. Search for the existing incident and click on the incident
5. Update the incidents with Urgency as High and State as In Progress
6. Verify the priority and state 
		 */
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(5);		
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		dom.findElementByXPath("//span[text()='Incidents']").click();
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys(inc_no, Keys.ENTER);
        driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td/a[contains(@class,'linked formlink')]")).click();
        WebElement urgency_value = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
        Select sec_urgency= new Select(urgency_value);
        sec_urgency.selectByValue("1");
        WebElement Incident_state=driver.findElement(By.xpath("//select[@id='incident.state']"));
        Select sec_state=new Select(Incident_state);
        sec_state.selectByValue("2");
       
        driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
        System.out.println("Updation completed");
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys(inc_no, Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(@class,'list_action list_top_title')]/span[text()='Incidents']")).click();
        WebElement findElement = driver.findElement(By.xpath("//div[text()='View']"));
        Actions build= new Actions(driver);
        build.moveToElement(findElement).perform();
        driver.findElement(By.xpath("//div[contains(text(),'Default view')]")).click();
        //fetching priority
        String priorty_value = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[7]")).getText();
        priorty_value=priorty_value.substring(0,1);
        String state_value = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[8]")).getText();
        if (state_value.contains("In Progress"))
        {
        	System.out.println("State value updated successfully -"+inc_no);
        }
        else
        {
        	System.out.println("State value not updated--"+inc_no);
        }
        
        if(priorty_value.contains("3"))
        {
        	System.out.println("Priorty value updated successfully--"+inc_no);
        }
        else
        {
        	System.out.println("Priorty value not updated--"+inc_no);
        }	
        
        
        
        
                
        
	}
	
	@DataProvider
	public String[] sendingdata() throws IOException
	{
		String[] data= new String[5];
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook("./Data/UpdateIncident.xlsx");
		XSSFSheet sheet=workbook.getSheetAt(0);
		int row_no= sheet.getLastRowNum();
		int col_no=sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count : "+row_no+" Column no :"+col_no);
		int k=0;
		for(int i=1;i<=row_no;i++)
		{
			k=i;
			String values=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(values);
			data[k-1]=values;
		}
				
		return data;
		
	}
	
	}

