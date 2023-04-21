package Marathon3;



import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class contentLink extends BaseClassForMarathon{
	@BeforeTest
	public void getFileName()
	{
		ExcelFileName="Contentlink";
	}
	
	@Test(dataProvider = "sendingdata")
	public  void runContentLink(String question_text,String answer_text) {
		String title = driver.getTitle();
		System.out.println(title);
        WebElement app_launcher = driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]"));
        Actions build=new Actions(driver);
        build.moveToElement(app_launcher).perform();
        driver.executeScript("arguments[0].click()", app_launcher);
        driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
        driver.findElement(By.xpath("//input[@class='slds-input' and @type='search']")).sendKeys("Content");
        driver.findElement(By.xpath("//span/p[@class='slds-truncate']/mark[text()='Content']")).click();
        WebElement findElement = driver.findElement(By.xpath("//span[text()='Chatter']"));
        driver.executeScript("arguments[0].click()", findElement);
        System.out.println("Title of the Page :"+driver.getTitle());
        driver.findElement(By.xpath("//span[text()='Question']")).click();
        driver.findElement(By.xpath("//textarea[contains(@class,'cuf-questionTitleField')]")).sendKeys(question_text);
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor')]")).sendKeys(answer_text);
        driver.findElement(By.xpath("//button[text()='Ask']")).click();
        String question_text1 = driver.findElement(By.xpath("//div[contains(@class,'forceChatterFeedBodyQuestionWithoutAnswer')]/span[@class='uiOutputText']")).getText();
        System.out.println(question_text1);
        if(question_text1.contains("What"))
        {
        	System.out.println("Question displayed correctly");
        }
        else
        {
        	System.out.println("Question not displayed correctly");
        }         
           
	}
	@DataProvider
	public String[][] sendingdata() throws IOException
	{
		return Datafromexcel.datafromexcel(ExcelFileName);
	}

}
