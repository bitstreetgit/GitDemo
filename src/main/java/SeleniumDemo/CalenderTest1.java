package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderTest1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		// Date of Travel
		 driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
		 
		//Month
		//In while we putting element if current month is not September then it will loop continues and once it found desired month click on next button
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-title']")).getText().contains("September"))
		{
			driver.findElement(By.cssSelector("a[title='Next']")).click();
		}
		
		// driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
		// Select Date :15-06
		List<WebElement> date = driver.findElements(By.cssSelector(".ui-state-default"));
		int count = driver.findElements(By.cssSelector(".ui-state-default")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.cssSelector(".ui-state-default")).get(i).getText();
			if (text.equalsIgnoreCase("15")) {
				driver.findElements(By.cssSelector(".ui-state-default")).get(i).click();
				
			}
		}
	}
}
