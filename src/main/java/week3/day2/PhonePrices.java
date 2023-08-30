package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PhonePrices {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://amazon.in");
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement search = driver.findElement(By.xpath("//input[contains(@aria-label,'Search Amazon.in')]"));
		search.sendKeys("Phone");

		// nav-search-submit-button

		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> allPhonePrices = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));

		for (WebElement element : allPhonePrices) {

			System.out.println(element.getText());

		}

	}

}
