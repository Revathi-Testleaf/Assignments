package week5.TestNG;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
@Test
public class EditTask extends SalesForceConnection{

	public void runEditTask() throws InterruptedException {
		/**
		 * Test Steps:
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Tasks tab 
5.Click on Dropdown icon available under tasks and select value as Recently viewed
6. Click the Dropdown for Bootcamp task and select Edit
7. Select todays date as Due date
8. Select Priority as low
10. Click save and verify Subject**/
	/**	ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(options);        
        driver.get("https://qeagle-dev-ed.my.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        Thread.sleep(2000);
        WebElement findElement = driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]"));
        Actions build=new Actions(driver);
        build.moveToElement(findElement).perform();
        driver.executeScript("arguments[0].click()", findElement);**/
		
        driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement findElement2 = driver.findElement(By.xpath("//span[text()='Tasks']"));
        driver.executeScript("arguments[0].click()", findElement2);
        driver.findElement(By.xpath("//button[contains(@title,'Select a List View')]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//a[@role='option']//span[contains(text(),'Recently Viewed')]")).click();
        driver.findElement(By.xpath("//a[contains(@title,'Show 9 more actions')]")).click();
        driver.findElement(By.xpath("//a[contains(@data-target-selection-name,'sfdc:StandardButton.Task.Edit')]")).click();
        
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	   String formattedDate = sdf.format(date);
	   driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).clear();
	   driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(formattedDate);
	   driver.findElement(By.xpath("//span[contains(@data-aura-class,'uiPicklistLabel')]/span[text()='Priority']/following::a[@class='select']")).click();
	   driver.findElement(By.xpath("//a[contains(@title,'Low')]")).click();
	   driver.findElement(By.xpath("//span[text()='Save']")).click(); 
	   String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
       System.out.println("Verified message :" + text); 
       Thread.sleep(1500);       

	}

}
