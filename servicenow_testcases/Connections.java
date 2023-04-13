package servicenow_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Connections {
	public ChromeDriver driver;
	@Parameters({"url","uname","password"})
	@BeforeMethod
	public void urlconnections(String url, String uname, String password)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");		
		driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(uname);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
	}
	@AfterMethod
	public void urlclose()
	{
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
