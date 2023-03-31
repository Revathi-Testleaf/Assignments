package week4.day1.Assignmentw4d1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcUrl {

	public static void main(String[] args) throws IOException {
		
       
/**1.Load this url(https://www.irctc.co.in/nget/train-search)
 2.Click Flights
3.Get the title and print in the consol**/
		
	
	
		        ChromeOptions options=new ChromeOptions();
		        options.addArguments("--remote-allow-origins=*");
		        options.addArguments("--disable-notifications");
		        ChromeDriver driver=new ChromeDriver(options);
		        
		        driver.get("https://www.irctc.co.in/nget/train-search");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		        driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		        Set<String> windowHandles = driver.getWindowHandles();
		        List<String> list=new ArrayList<String>(windowHandles);
		        System.out.println(windowHandles);
		        driver.switchTo().window(list.get(1));
		        String title=driver.getTitle();
		        System.out.println(title);
		        File src=driver.getScreenshotAs(OutputType.FILE);
		        File dst=new File("./ScreenShots/flight.png");
		        FileUtils.copyFile(src, dst);		  

	}

}
