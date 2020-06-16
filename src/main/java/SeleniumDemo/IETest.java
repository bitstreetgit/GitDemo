package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}
}
