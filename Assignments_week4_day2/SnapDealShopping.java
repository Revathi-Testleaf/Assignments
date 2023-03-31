package week4.day2.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDealShopping {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(options);        
        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement findElement = driver.findElement(By.xpath("//li[contains(@class,'navlink')]//span[contains(text(),'Men')]"));
        Actions build=new Actions(driver);
        build.moveToElement(findElement).perform();
        driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
        String count_shoes = driver.findElement(By.xpath("//h1[contains(@category,'Sports Shoes for Men')]/following-sibling::span[contains(@class,'category-name category-count')]")).getText();
        count_shoes=count_shoes.replaceAll("[^0-9]","");
		System.out.println("Count for sports shoes for men :"+count_shoes);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//div[contains(@class,'sort-selected')]")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li[@class='search-li'])[1]")).click();		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'filter-type-name lfloat')])[4]")).click();	
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[contains(@class,'navFiltersPill')]"));
		System.out.println(findElements.get(0).getText());
		System.out.println(findElements.get(1).getText());
		WebElement findElement2 = driver.findElement(By.xpath("//p[contains(@class,'product-title')]"));
		Actions build1= new Actions(driver);
		build1.scrollToElement(findElement2).perform();				
		WebElement findElement3 = driver.findElement(By.xpath("(//div[contains(@class,'quick-view-bar')])[1]"));
		driver.executeScript("arguments[0].click()", findElement3);
		String cost = driver.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l clearfix')]/span[@class='payBlkBig']")).getText();
		String per = driver.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l clearfix')]/span[@class='percent-desc ']")).getText();
		System.out.println("cost :"+cost+"  percentage :"+per);
		File src=driver.getScreenshotAs(OutputType.FILE);
        File dst=new File("./ScreenShots/Shoes.png");
        FileUtils.copyFile(src, dst);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,'close close1 marR10')]")).click();
        driver.quit();
		
	}

}
