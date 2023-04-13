package week5.TestNG;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteExistingCaller extends  CallerBaseClass{
	@Test
	public void runDeleteExistingCaller() throws InterruptedException {
	
        Shadow dom=new Shadow(driver);
        dom.setImplicitWait(25);
        dom.findElementByXPath("//div[text()='All']").click();      
        dom.setImplicitWait(5);
        dom.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
        dom.findElementByXPath("//span[text()='Callers']").click();
        WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys("Naavya",Keys.ENTER);
        Thread.sleep(1500);
        dom.findElementByXPath("//td[@name='first_name']//input[contains(@class,'list_header_search  form-control form-control-search')]").sendKeys("Naavya",Keys.ENTER);
        List<WebElement> noofrecords = driver.findElements(By.xpath("//tbody[@class='list2_body']/tr"));
        int len=noofrecords.size();
        System.out.println("No of records found for first name Naavya- is"+ noofrecords.size());
        driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td/span[@class='input-group-checkbox']")).click();
    //    WebElement findElement = (WebElement) driver.findElements(By.xpath("//select[contains(@class,'list_action_option form-control')]"));
        Select sec=new Select(driver.findElement(By.xpath("//select[contains(@class,'list_action_option form-control')]")));
        sec.selectByVisibleText("Delete");
        
        driver.findElement(By.xpath("//button[@id='ok_button']")).click();
        dom.findElementByXPath("//td[@name='first_name']//input[contains(@class,'list_header_search  form-control form-control-search')]").clear();
        dom.findElementByXPath("//td[@name='first_name']//input[contains(@class,'list_header_search  form-control form-control-search')]").sendKeys("Naavya",Keys.ENTER);
        
        List<WebElement> newnoofrecords = driver.findElements(By.xpath("//tbody[@class='list2_body']/tr"));
        int new_len=newnoofrecords.size();
        System.out.println(new_len);
        if(new_len==len)
        {
        	System.out.println("Record not deleted");
        }
        else
        {
        	System.out.println("Record  deleted");
        }               
        
	}

}
