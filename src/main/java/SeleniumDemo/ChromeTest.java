package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	public static void main(String[] args) {

		System.out.println("Hello world");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());// to validate u landed on correct page
		// System.out.println(driver.getPageSource());//to get page source
		driver.get("https://in.yahoo.com/?p=us");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.close(); //It closes current browser
		//driver.quit(); //It closes all the browser opened by selenium script
	}
}
