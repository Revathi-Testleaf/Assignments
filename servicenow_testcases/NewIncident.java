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

public class NewIncident extends Connections{
	
@Test(dataProvider="sendingdata")
	public  void runNewIncident(String urgency,String state,String short_des,String add_comment ) throws InterruptedException {
	
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(5);		
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		dom.findElementByXPath("//span[text()='Incidents']").click();
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(frame);
        WebElement findElement = driver.findElement(By.xpath("//button[@id='sysverb_new']"));
        driver.executeScript("arguments[0].click()", findElement);        
        Thread.sleep(1500);
        String incident_openeddate=driver.findElement(By.xpath("//input[@id='incident.opened_at']")).getAttribute("value");
        System.out.println("Incident created date :"+incident_openeddate);
        WebElement urgency_value = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
        Select sec_urgency= new Select(urgency_value);
        sec_urgency.selectByValue(urgency);
        WebElement Incident_state=driver.findElement(By.xpath("//select[@id='incident.state']"));
        Select sec_state=new Select(Incident_state);
        sec_state.selectByVisibleText(state);
        driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(short_des);
        driver.findElement(By.xpath("//textarea[@id='incident.comments']")).sendKeys(add_comment);
        Thread.sleep(1500);
        String new_incident_no=driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");   
        System.out.println("New created Incident Id :"+ new_incident_no);
        driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys(new_incident_no, Keys.ENTER);
        List<WebElement> findElements = driver.findElements(By.xpath("//tbody[@class='list2_body']/tr"));
        int len=findElements.size();
        if(len>0)
        {
        	System.out.println("New Incident created with id :"+new_incident_no);
        }
        else
        {
        	System.out.println("New Incident not created");
        }
		// TODO Auto-generated method stub

	}
@DataProvider
public String[][] sendingdata() throws IOException
{
	String[][] data=new String[3][4];
	@SuppressWarnings("resource")
	XSSFWorkbook worksheet=new XSSFWorkbook("./Data/CreateIncident.xlsx");
	XSSFSheet sheet=worksheet.getSheetAt(0);
	int rowcount=sheet.getLastRowNum();
	int columncount=sheet.getRow(0).getLastCellNum();
	System.out.println("Row count :"+rowcount+" Column count :"+columncount);
	int k=0;
	for(int i=1;i<=rowcount;i++)
	{
		k=i;
		for(int j=0;j<columncount;j++)
			
		{
			//System.out.println("i---:"+i+"j---"+j);
			String values= sheet.getRow(i).getCell(j).getStringCellValue();
			//System.out.println(values);
			data[k-1][j]=values;
		}
	}
	
	return data;
}

}
