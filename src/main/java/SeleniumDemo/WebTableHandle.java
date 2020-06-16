package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		// Our target is to get all values present at 3rd column price
		// Whole parent table xpath
		WebElement table = driver.findElement(By.xpath("//*[@id='product']/tbody"));
		// Table Rows
		List<WebElement> rows = table.findElements(By.xpath("//*[@id='product']/tbody/tr"));
		int rowCount = rows.size();
		// Table Column - 3rd column
		List<WebElement> colCount = table.findElements(By.xpath("//*[@id='product']/tbody/tr/td[3]"));
		int count = colCount.size();
		for (int i = 0; i < count; i++) {
			String price = table.findElements(By.xpath("//*[@id='product']/tbody/tr/td[3]")).get(i).getText();
			System.out.println(price);
		}
	}
}
