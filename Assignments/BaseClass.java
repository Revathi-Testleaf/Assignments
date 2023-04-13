package week5.day2.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public ChromeDriver driver;
	Set<String> windowHandle1;
	List<String> list1;
	
	@Parameters({"url","password"})
	@BeforeMethod(alwaysRun = true)
	public void precondition(String url,String password)
	{
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);        
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(url);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='Login']")).click();
	}
	@AfterMethod(alwaysRun = true)
	public void postcondition()
	{
		System.out.println("inside postcondition");
		Set<String> windowHandle1 = driver.getWindowHandles();
        List<String> list1=new ArrayList<String>(windowHandle1);    
        int no_window=list1.size();
        driver.switchTo().window(list1.get(0));
        for(int i=0;i<no_window;i++)
		{
		driver.switchTo().window(list1.get(i)).close();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
