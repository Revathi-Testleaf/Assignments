package week2.day1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origin*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://mail.google.com/");
		//driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//driver.close();
	}

}
