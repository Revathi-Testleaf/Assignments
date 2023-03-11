package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();	
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(3000);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create Lead")).click();
		String title1=driver.getTitle();
		System.out.println(title1);
	
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NASA");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Naavya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Lakshminarayanan");
		WebElement sourceWD= driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sec= new Select(sourceWD);
		sec.selectByIndex(4);
		WebElement sourceMC=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select sec1=new Select(sourceMC);
		sec1.selectByVisibleText("Automobile");
		WebElement sourceOWN=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select sec2=new Select(sourceOWN);
		sec2.selectByValue("OWN_CCORP");
		Thread.sleep(2000);
		driver.findElement(By.className("smallSubmit")).click();
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		driver.close();
		
	}

}
