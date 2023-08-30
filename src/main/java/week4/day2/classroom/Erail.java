package week4.day2.classroom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Erail {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.click();
		fromStation.clear();
		fromStation.sendKeys("MAS", Keys.TAB);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));

		toStation.clear();
		toStation.sendKeys("CBE", Keys.TAB);

		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

		driver.findElement(By.id("buttonFromTo")).click();

		List<WebElement> trainNamesElement = driver.findElements(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//td[2]"));

		for (WebElement td : trainNamesElement) {

			//System.out.println(td.getText());
		}

		WebElement trainList = driver.findElement(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody"));

		List<WebElement> rowsElement = trainList.findElements(By.tagName("tr"));

		System.out.println(rowsElement.size());

		for (int i = 0; i < rowsElement.size(); i++) {
			// Skipping header <th>
			if (i == 0)
				continue;

			List<WebElement> colsElement = rowsElement.get(i).findElements(By.tagName("td"));
			System.out.println(colsElement.size());
			if (colsElement.size() > 1) {
				WebElement trainNameElement = colsElement.get(1);
				System.out.println(trainNameElement.getText());
			}
		}

	}
}
