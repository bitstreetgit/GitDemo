package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		// Customized xpath
		// tagname[@attribute='value'] - xpath
		/*
		 * driver.findElement(By.xpath("//*[@type='email']")).sendKeys("test@gmail.com");
		 * driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456");
		 * driver.findElement(By.xpath("//input[@value='Log In']")).click();
		 */
		// LinkText
		// driver.findElement(By.linkText("Forgotten account?")).click();

		// tagname[attribute='value'] - Css selector
		// tagname#id - input#email
		// .classname
		
		//Regular Expression
		//Eg - <input name="username123">
		//input[contains(@name,'username') - xpath
		//input[name*='username'] - css

		driver.findElement(By.cssSelector("#email")).sendKeys("test@gmail.com"); // id
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("123456");// name
		driver.findElement(By.cssSelector("input[aria-label='Log In']")).click();

	}
}
