package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingTestLeaf {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println(driver.getTitle());
        String parent_window = driver.getWindowHandle();
        System.out.println(parent_window);
      
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> windowHandle = driver.getWindowHandles();
        List<String> list=new ArrayList<String>(windowHandle);        
        System.out.println(windowHandle);      
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(parent_window);     
        System.out.println(driver.getTitle());        
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> arrayList = new ArrayList<String>(windowHandles);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        Set<String> windowHandles1 = driver.getWindowHandles();
        List<String> arrayList1 = new ArrayList<String>(windowHandles1);
        System.out.println(arrayList1);
        System.out.println(arrayList1.size());
        driver.switchTo().window(arrayList1.get(1));
        for (String each : arrayList1) {
        	if(!parent_window.equals(each)) {
        	
        		System.out.println(each);
        		Thread.sleep(3000);
        		driver.switchTo().window(each);
        		driver.close();        				
        	}    
        	else
        	{
        		System.out.println("Dont close, its the parent window :"+each);
        	}
        	driver.switchTo().window(parent_window);
	}
        Thread.sleep(2000);
        driver.close();

}
}
