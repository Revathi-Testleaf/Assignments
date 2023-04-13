package week5.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SalesForceConnection {
	public ChromeDriver driver;
	@BeforeMethod
	public void Connections()
	{
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);        
        driver.get("https://qeagle-dev-ed.my.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        WebElement findElement = driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]"));
        Actions build=new Actions(driver);
        build.moveToElement(findElement).perform();
        driver.executeScript("arguments[0].click()", findElement);  
	}
	@AfterMethod
	public void closingDrivers()
	{
		 driver.close();
	}

	
}
