package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");

		// To find whether frame is present
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		// If only one frame is present we can directly switch to 0 th frame
		// driver.switchTo().frame(0);

		// Clicking on element which is inside frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.id("draggable")).click();

		// Drag and drop
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();

		// Switch back to main page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Blog']")).click();
	}
}
