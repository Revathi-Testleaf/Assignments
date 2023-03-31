package week4.day2.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaShopping {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(options);        
        driver.get("https://www.nykaa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement findElement=driver.findElement(By.xpath("//a[text()='brands']"));	
		Actions build=new Actions(driver);
		build.moveToElement(findElement).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		
		driver.findElement(By.xpath("//div[@class='control-value']/span[contains(text(),'customer top rated')]")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Hair Care']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[contains(@class,'control control-checkbox')]//span[text()='Shampoo']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1500);
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='css-rtde4j']//span[@class='filter-value']"));
		System.out.println("no of filter :"+findElements.size());
		for(int i=0;i<findElements.size();i++)
		{
			System.out.println(findElements.get(i).getText());
		}
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		Set<String> windowHandle = driver.getWindowHandles();
        List<String> list=new ArrayList<String>(windowHandle);        
        driver.switchTo().window(list.get(1));
        driver.findElement(By.xpath("//span[text()='180ml']")).click();
        String price = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
        price = price.replaceAll("[^a-zA-Z0-9]", "");
        int priceInt = Integer.parseInt(price);
        System.out.println("MRP of the product :"+priceInt);
        
               
        driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='cart-count']/preceding-sibling::*[name()='svg']")).click();
        Thread.sleep(2000);
        WebElement findElement2 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
        driver.switchTo().frame(findElement2);
        String grand_total = driver.findElement(By.xpath("(//div[contains(@class,'footer-layout')]//span)[1]")).getText();
        grand_total = grand_total.replaceAll("[^a-zA-Z0-9]", "");
        int totalInt = Integer.parseInt(grand_total);
        System.out.println("Grand Total Amount :"+ totalInt);
                
        if(totalInt==priceInt) 	 
        {
        System.out.println("Grand Total is same as MRP");
        }
        else
        {
        	System.out.println("Grand total includes shipping charges");
        }
        driver.findElement(By.xpath("//div[contains(@class,'footer-layout')]//span[contains(text(),'Proceed')]")).click();
         Thread.sleep(2000);
         driver.quit();
        
	}

}
