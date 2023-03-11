package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origin*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(3000);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Government");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Naavya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Lakshminarayanan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Navi");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Driver");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("For testing purpose");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("navi_dream@gmail.com");
		WebElement sourceSP=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sec=new Select(sourceSP);
		sec.selectByVisibleText("Armed Forces Europe");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Corporate");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Naavyashree");
		driver.findElement(By.className("smallSubmit")).click();
		String str=driver.getTitle();
		System.out.println(str);
		Thread.sleep(2000);
		driver.close();

	}

}
