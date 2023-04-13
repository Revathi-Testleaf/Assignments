package week5.TestNG;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewCaller extends CallerBaseClass {
	@Test(dataProvider = "passing_data")
	public  void runCreateNewCaller(String fname, String lname, String email,String phno) throws InterruptedException {
			
        Shadow dom=new Shadow(driver);
        dom.setImplicitWait(25);
        dom.findElementByXPath("//div[text()='All']").click();      
        dom.setImplicitWait(5);
        //dom.findElementByXPath("//input[@id='filter']").clear();
        dom.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
        dom.findElementByXPath("//span[text()='Callers']").click();
        WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(frame);
        WebElement findElement = driver.findElement(By.xpath("//button[@id='sysverb_new']"));
        driver.executeScript("arguments[0].click()", findElement);
        driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
        driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
        driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(phno);
        driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();  
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(fname,Keys.ENTER);
        List<WebElement> findElements = driver.findElements(By.xpath("//div[contains(@class,'list_div_parent')]//tbody//tr"));
        System.out.println("Number of rows :"+findElements.size());
        int i=findElements.size();
      //  String text_name = driver.findElement(By.xpath("//div[contains(@class,'list_div_parent')]//tbody//tr//td[4]")).getText();
        
        if(i>0)
        {
        	System.out.println("New caller created with "+fname+" as first name");
        }
        else
        	System.out.println("New caller is not created with "+fname+" as first name");   
        
        
        
	}
	@DataProvider
	public String[][] passing_data()
	{
		String[][] data=new String[2][4];
		data[0][0]="Shivanya";
		data[0][1]="Saravanan";
		data[0][2]="create@gmail.com";
		data[0][3]="8756005623";

		data[1][0] = "Sanjay";
		data[1][1] = "Saravanan";
		data[1][2] = "source@gmail.com";
		data[1][3] = "4006534568";
		
		return data;
	}
	

}
