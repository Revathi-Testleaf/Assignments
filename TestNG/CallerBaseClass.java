package week5.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CallerBaseClass {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void connections(String url,String username,String password )
	{
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);        
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	}
	@AfterMethod
	public void close_fun() throws InterruptedException
	{
		Thread.sleep(2000);
        driver.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
