package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		System.out.println("Hello world");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Currency - Select Dropdown - Static Dropdown
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByIndex(2);
		s.selectByValue("AED");
		s.selectByVisibleText("USD");
		
		//Passengers
		driver.findElement(By.id("divpaxinfo")).click();
		/*
		   int i = 1; 
		   while (i < 5) {
		   driver.findElement(By.id("hrefIncAdt")).click(); 
		   i++;
		    }
		 */
		System.out.println("***before***");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); //get dropddown text
		
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); //4 times click on adult +
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("***after***");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
}
