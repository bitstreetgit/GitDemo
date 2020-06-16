package SeleniumDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScope {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// 1.Print count of link on page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2.Print links count present at footer section
		// limiting webdriver scope
		WebElement footerdriver = driver.findElement(By.cssSelector("div#gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// 3.Get links count present in 1st column of footer
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		// 4.Click on each link in column and check whether its working
		// for loop opening all the tabs in separate windows
		for (int i = 0; i < columndriver.findElements(By.tagName("a")).size(); i++) {

			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);//to open link
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		}

		// Get all windows title
		// hasNext() will check whether next element is present
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
