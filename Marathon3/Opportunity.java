package Marathon3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Opportunity extends BaseClassForMarathon {
	@BeforeTest
	public void getFileName()
	{
		ExcelFileName="OpportunitySalesforce";
	}
	
	@Test(dataProvider = "sendingdata")
	public void runOpportunity(String opp_name,String amount) throws InterruptedException {
		System.out.println(driver.getTitle());
		WebElement app_launcher = driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]"));
		Actions build = new Actions(driver);
		build.moveToElement(app_launcher).perform();
		driver.executeScript("arguments[0].click()", app_launcher);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		driver.findElement(By.xpath("//input[@class='slds-input' and @type='search']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//span/p[@class='slds-truncate']/mark[text()='Sales'])[3]")).click();
		Thread.sleep(2000);
		WebElement drop_button = driver.findElement(By.xpath("//a[contains(@title,'Key Deals Trigger')]"));
		Actions build1 = new Actions(driver);
		build1.moveToElement(drop_button).perform();
		driver.executeScript("arguments[0].click()", drop_button);
		driver.findElement(By.xpath("//a[contains(@title,'All Opportunities')]")).click();
		WebElement view_all = driver.findElement(By.xpath("//span [contains(text(),'View All Key Deals')]"));
		Actions build2 = new Actions(driver);
		build2.moveToElement(view_all).perform();
		driver.executeScript("arguments[0].click()", view_all);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Opportunity Name')]/following-sibling::div[contains(@class,'slds-form-element__control slds-grow')]/input")).sendKeys(opp_name);
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux slds-combobox__input-value')])[2]")).click();
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux slds-combobox__input-value')])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		Thread.sleep(2000);
		/**
		 * Fetching current date from sys cal and added one day Date curr_date=new
		 * Date(); System.out.println(curr_date); SimpleDateFormat dateFormat = new
		 * SimpleDateFormat( "dd/MM/yyyy" ); Calendar cal = Calendar.getInstance();
		 * cal.setTime( dateFormat.parse(curr_date)); cal.add( Calendar.DATE, 1 );
		 * String convertedDate=dateFormat.format(cal.getTime());
		 * System.out.println("Date increase by one.."+convertedDate);	
		
		 * Fetching from calander as table row/col driver.findElement(By.xpath(
		 * "//table[@class='slds-datepicker__month']/tbody/tr[4]//td[5]")).click();
		 * driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(
		 * convertedDate);
		 * driver.findElement(By.xpath("//button[text()='Today']")).click();
		 * Thread.sleep(2000);
		 */

		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();		
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		String date_cal = driver.findElement(By.xpath("//input[@name='CloseDate']")).getAttribute("value");	
		System.out.println("date :" + date_cal);
		String new_string = date_cal;
		new_string = new_string.substring(0, 2);
		int new_date = Integer.parseInt(new_string);
		new_date = new_date + 1;
		String dt = Integer.toString(new_date);
		String ol_date = date_cal.substring(2, 10);
		dt = dt.concat(ol_date);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(dt);
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux slds-combobox__input-value')])[1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
		String suc_text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println("Success Message :" + suc_text);

	}
	@DataProvider
	public String[][] sendingdata() throws IOException
	{
		return Datafromexcel.datafromexcel(ExcelFileName);
	}
}
