package week5.TestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateTastWithoutReqField extends SalesForceConnection{
@Test
	public void runCreateTastWithoutReqField() throws InterruptedException {
		/*
		  Test Steps:
1) Launch the app
2) Click Login
3) Login with the credentials
4) Click on toggle menu button from the left corner
5) Click view All and click Sales from App Launcher
6) Click ontask and click New Task
7) Select Name from Dropdown
8) Enter Coments as SALES FORCE Automation Using Selenium
9) Click on Save 
10) Get the text of Error message Displayed and Verify the message
		 */
	/**	ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(options);        
        driver.get("https://qeagle-dev-ed.my.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        Thread.sleep(2000);
        WebElement findElement = driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]"));
        Actions build=new Actions(driver);
        build.moveToElement(findElement).perform();
        driver.executeScript("arguments[0].click()", findElement);**/
       // driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        driver.findElement(By.xpath("//a[@title='Tasks']/following::*[name()='svg'and @data-key='chevrondown']")).click();
        WebElement findElement2 = driver.findElement(By.xpath("//span[contains(text(),'New Task')]"));
        driver.executeScript("arguments[0].click()", findElement2);
        driver.findElement(By.xpath("//span[contains(text(),'Name')]/following::a[contains(@aria-label,'Name—Current Selection')]")).click();
        driver.findElement(By.xpath("//span[@title='Contacts']")).click();
        driver.findElement(By.xpath("//input[contains(@title,'Search Contacts')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'primaryLabel')]")).click();
        driver.findElement(By.xpath("//span[text()='Save']")).click(); 
        String text = driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
        System.out.println("Error Message : "+text);
        Thread.sleep(2000);       
        
		
	}

}
