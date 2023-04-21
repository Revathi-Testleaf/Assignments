package Marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClassForMarathon {
	public RemoteWebDriver driver;
	public String ExcelFileName;
	
	@Parameters({"browser","url","username","password"})
	@BeforeMethod(alwaysRun = true)
	public void preCondition(String browser,@Optional("https://login.salesforce.com/")String url,
			@Optional("revu@testleaf.com")String uName,@Optional("Leaf@001")String pWord) throws InterruptedException {
		if(browser.equalsIgnoreCase("Chrome"))
		{

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver();    
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}	
		else
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver();
		}
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pWord);
        driver.findElement(By.xpath("//input[@id='Login']")).click();   
        //Thread.sleep(2000);

	}

	@AfterMethod(alwaysRun = true)
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider
	public String[][] sendingData(String ExcelFileName) throws IOException
	{
		return Datafromexcel.datafromexcel(ExcelFileName);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
