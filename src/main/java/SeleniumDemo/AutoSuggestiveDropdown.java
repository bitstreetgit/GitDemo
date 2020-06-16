package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		//From
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.clear();
		from.sendKeys("MUM");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//To
		//driver.findElement(By.xpath("//label[@for='toCity']")).click();
		WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to.clear();
		to.sendKeys("DEL");
		Thread.sleep(2000);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		
	}

}
