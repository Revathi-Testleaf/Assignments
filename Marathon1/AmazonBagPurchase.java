package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonBagPurchase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
	    driver.findElement(By.xpath("//div[contains(@class,'s-suggestion')]/span[contains(text(),'for boys')]")).click();
	    //driver.findElement(By.xpath("(//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')])[1]")).click();
	    WebElement findElement = driver.findElement(By.xpath("(//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')])[1]"));
	    System.out.println(findElement.getText());
	    driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox')]//i[contains(@class,'a-icon a-icon-checkbox')])[2]")).click();
	    driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox')]//i[contains(@class,'a-icon a-icon-checkbox')])[3]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]")).click();
	    driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	    WebElement findElement2 = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[1]"));
	    System.out.println("Name of the Bag :"+findElement2.getText());
	    WebElement findElement3 = driver.findElement(By.xpath("//span[contains(@class,'a-price-whole')]"));
	    System.out.println("Discounted Price :"+findElement3.getText());	    
	    System.out.println(driver.getTitle());
	    driver.close();    
	    
	}	
}
