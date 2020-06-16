package SeleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List<WebElement> productsList = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < productsList.size(); i++) {
			String productName = productsList.get(i).getText();
			// System.out.println(productName);
			if (productName.contains("Cucumber")) {
				// Click on Add To Cart - only one item will get add
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
	}
}
