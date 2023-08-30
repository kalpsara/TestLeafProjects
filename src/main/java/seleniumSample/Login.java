package seleniumSample;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

	public static void main(String[] args) {
		
			//driver location
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//driver.get(" https://www.facebook.com/login");
		driver.manage().window().maximize();

		//System.out.println(driver.getTitle());
		driver.close();

		// Click on the search button
		// driver.findElement(By.className("decorativeSubmit")).click();

		// Close the Browser
		// driver.close();
	}

}
