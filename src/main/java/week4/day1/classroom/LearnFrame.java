package week4.day1.classroom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm ");
		driver.manage().window().maximize();
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frameElement);//
		
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text = driver
				.findElement(By.xpath("//h2[contains(text(),'JavaScript Confirm Box')]/following-sibling::p"))
				.getText();

		System.out.println(text);
		
		driver.get("https://www.w3schools.com");

	}

}
