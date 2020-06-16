package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

	public static void main(String[] args) {
		
		System.out.println("Hello world");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
