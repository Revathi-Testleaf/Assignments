package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBusTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String str=driver.getTitle();
        System.out.println(str);
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("chennai");
        driver.findElement(By.xpath("//li[@class='selected']")).click();
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//li[@class='selected']")).click();
        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
        driver.findElement(By.xpath("//td[@class='current day']")).click();
        driver.findElement(By.xpath("//button[@id='search_btn']")).click();
        String str_found=driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        System.out.println(str_found);    	
        WebElement click_sleep=driver.findElement(By.xpath("//input[@id='bt_SLEEPER']"));
        driver.executeScript("arguments[0].click();",click_sleep);     
        String str2=driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
        System.out.println(str2);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.close();
        }

}
