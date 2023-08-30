package week4.day1.classroom;

import java.util.Set;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windHandle = driver.getWindowHandles();

		List<String> windowList = new ArrayList<String>(windHandle);
		System.out.println(windowList);
		System.out.println(driver.switchTo().window(windowList.get(1)).getTitle());

		driver.switchTo().window(windowList.get(0)).close();

		// System.out.println(driver.getTitle());

	}

}
