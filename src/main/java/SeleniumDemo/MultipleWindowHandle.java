package SeleniumDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// parent window
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		// child window
		driver.findElement(By.xpath("//*[@id='initialView']/footer/ul/li[2]/a")).click();
		System.out.println(driver.getTitle());
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);
		System.out.println("After Switching to child window");
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.println("After Switching back to parent window");
		System.out.println(driver.getTitle());
	}
}
