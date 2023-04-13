package week5.TestNG;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;**/
import org.testng.annotations.Test;

public class CreateTask extends SalesForceConnection{
	
	
@Test
	public void runCreateTask() throws InterruptedException {
		/**Url:https://qeagle-dev-ed.my.salesforce.com/
			UserName:hari.radhakrishnan@qeagle.com
			Password:Leaf@123
		 	**/
		
       // Thread.sleep(2000);
             
        driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
        driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("task");
        driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
        driver.findElement(By.xpath("//a[@title='Tasks']/following::*[name()='svg'and @data-key='chevrondown']")).click();
        Thread.sleep(1500);
        WebElement findElement2 = driver.findElement(By.xpath("//span[contains(text(),'New Task')]"));
        driver.executeScript("arguments[0].click()", findElement2);
        driver.findElement(By.xpath("//input[contains(@class,'slds-combobox__input slds-input')]")).sendKeys("Bootcamp");              
        driver.findElement(By.xpath("//span[contains(@data-aura-class,'uiPicklistLabel')]/following::a[@class='select']")).click();
        driver.findElement(By.xpath("//a[contains(@title,'Waiting on someone else')]")).click();  
        driver.findElement(By.xpath("//span[text()='Save']")).click(); 
        if(driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText() != null)
        {
        String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println("Verified message :" + text);
        Thread.sleep(1500);
        if(text.contains("was created"))
        	System.out.println("Tasks created");
        else
        	System.out.println("Tasks not created");
        }
        else
        	System.out.println("unexpected Error happened");            
  
        
	}

}
