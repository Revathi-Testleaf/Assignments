package week5.day2.Assignments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class administratorCertificate extends BaseClass {
	@Test(groups = "test",invocationCount = 2,timeOut = 25000 )
	public void runAdministratorCertificate() throws InterruptedException, IOException {

		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		String parent_window = driver.getWindowHandle();
		System.out.println(parent_window);
		driver.findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandle);

		System.out.println(windowHandle);
		driver.switchTo().window(list.get(1));
		Thread.sleep(1500);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		Thread.sleep(2000);
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[contains(text(),'Learning')]").click();

		WebElement findElement = dom.findElementByXPath("//span[contains(text(),'Learning on Trailhead')]");
		Actions build = new Actions(driver);
		build.moveToElement(findElement).perform();
		dom.findElementByXPath("//a[contains(text(),'Salesforce Certification')]").click();
		driver.findElement(By.xpath("(//button[text()='Accept All Cookies'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		System.out.println(driver.getTitle());
		// fetch the certificate names
		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]/a"));
		int len = findElements.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {

			System.out.println(findElements.get(i).getText());
		}

	}

}
