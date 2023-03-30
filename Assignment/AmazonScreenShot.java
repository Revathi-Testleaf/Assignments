package week4.day1.Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
        driver.findElement(By.xpath("//div[contains(@class,'s-suggestion-container')]/div[contains(text(),'oneplus 9 pro')]")).click();
        String first_price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        System.out.println(first_price);
        driver.findElement(By.xpath("(//h2[contains(@class,'a-size-mini a-spacing-none a-color-base s-line-clamp-2')]//span)[1]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> list=new ArrayList<String>(windowHandles);
        System.out.println(windowHandles);
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());        
        File src=driver.getScreenshotAs(OutputType.FILE);
        File dst=new File("./ScreenShots/LimitedTimeDeal.png");
        FileUtils.copyFile(src, dst);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        Thread.sleep(3000);
        String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
        System.out.println(subtotal);
        int end = subtotal.indexOf(".");
		System.out.println(end);
		subtotal=subtotal.substring(0,end);
		System.out.println(subtotal);
        subtotal = subtotal.replaceAll("[^a-zA-Z0-9]", "");
        first_price = first_price.replaceAll("[^a-zA-Z0-9]", "");
      
        System.out.println(first_price+"---"+subtotal);
      
        int number_first = Integer.parseInt(first_price);
        int number_sub = Integer.parseInt(subtotal);
        if(number_first==number_sub)
        {
        	System.out.println("Amount billed is correct "+number_sub);
        }
        else
        {
        	System.out.println("Amount billed is not correct "+number_sub);
        }
        Thread.sleep(2000);
        driver.quit();

	}

}
