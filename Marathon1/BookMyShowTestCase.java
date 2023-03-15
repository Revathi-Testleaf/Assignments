package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShowTestCase {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    String str=driver.getTitle();
	    System.out.println(str);
	    driver.findElement(By.xpath("//span[text()='Hyderabad']")).click();
	    String str2= driver.getCurrentUrl();
	    System.out.println(str2);
		driver.findElement(By.xpath("//span[contains(text(),'Search for Movies')]")).click();
		driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("RRR");		
		driver.findElement(By.xpath("//strong[text()='RRR']")).click();
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		
		System.out.println(driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]")).getText());
	
		driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
		WebElement findElement2 = driver.findElement(By.xpath("//div[contains(text(),'Parking Facility')]"));
		if(findElement2.isDisplayed())
		{
			System.out.println("Parking available for this show");
		}	
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		
		driver.findElement(By.xpath("(//div[@class='__details']/div[@class='__text'])[1]")).click();
			
		
		driver.findElement(By.xpath("//ul[@id='popQty']/li[@id='pop_1']")).click();
	
		driver.findElement(By.xpath("//div[contains(text(),'Select Seats')]")).click();
		
		driver.findElement(By.xpath("//div[@id='B_8_022']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'__seat-action btn-bar _centered _spaced')]/a[@id='btmcntbook']")).click();
		WebElement findElement = driver.findElement(By.xpath("//span[contains(@id,'subTT')]"));
		System.out.println(findElement.getText());
	   

	}

}
