package week4.day1.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mergecontact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");//DemoSalesManager
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Thread.sleep(3000);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		String pre_window = driver.getWindowHandle();
		System.out.println("previous window before widget :"+pre_window);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
	    List<String> list=new ArrayList<String>(windowHandles);
	    System.out.println(windowHandles);
	    driver.switchTo().window(list.get(1));		
		System.out.println(driver.getTitle());
		//driver.switchTo().frame("org.opentaps.gwt.crmsfa.crmsfa");	
		Thread.sleep(2000);		
		String text = driver.findElement(By.xpath("(//table[contains(@class,'x-grid3-row-table')]//tr[1]/td[1]//a)[1]")).getText();
		driver.findElement(By.xpath("(//table[contains(@class,'x-grid3-row-table')]//tr[1]/td[1]//a)[1]")).click();
		Thread.sleep(2000);
		System.out.println(text);
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
	    List<String> list1=new ArrayList<String>(windowHandles1);
	    System.out.println(windowHandles1);
	    driver.switchTo().window(list1.get(1));		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]")).getText();
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]")).click();
		System.out.println(text2);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
	}

}
