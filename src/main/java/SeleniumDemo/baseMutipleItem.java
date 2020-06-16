package SeleniumDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class baseMutipleItem {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver);
		//Cart Icon
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector(".promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		// promo code text
		String promoCodeText = driver.findElement(By.cssSelector(".promoInfo")).getText();
		Assert.assertEquals(promoCodeText, "Code applied ..!");
				
	}

	public static void addItems(WebDriver driver) {

		// Step 1 - To get multiple item add into cart,first create string array
		// and put desired item which needs to be added
		String[] cartItems = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

		List<WebElement> productsList = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < productsList.size(); i++) {

			// Step 4 - Format it to get actual vegetable name - Cucumber instead of Cucumber - 1 Kg
			// Split method gives array
			String[] productName = productsList.get(i).getText().split("-");

			// This will print Cucumber not Cucumber - 1 Kg
			String formattedProductName = productName[0].trim();

			// Step 2 - Convert array into array list
			// Step 3 - Check whether productName is extracted is present in array list or not
			List cartItemList = Arrays.asList(cartItems);

			// Use j variable to break once all 3 desired items get added else
			// it will iterate through 30 items
			int j = 0;
			if (cartItemList.contains(formattedProductName)) {
				j++;
				// Click on Add To Cart - only one item will get add
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == cartItems.length) {
					break;
				}
			}
		}
	}
}
