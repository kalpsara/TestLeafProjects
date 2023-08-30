package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDrown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf_v6");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("kalpana");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Saravanakumar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("kalpss");
		driver.findElement(By.name("departmentName")).sendKeys("tester");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium tester");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("venkatraman.kalpana@gmail.com");
		
		WebElement industry=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industryDropdown=new Select(industry);
		industryDropdown.selectByIndex(3);
		Thread.sleep(2000);
		
		
		
		WebElement ownership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownershipDropdown=new Select(ownership);
		ownershipDropdown.selectByVisibleText("Public Corporation");
		Thread.sleep(2000);
		
		//driver.findElement(By.name("submitButton")).click();
	
		System.out.println(driver.getTitle());
		
		
		


	}

}
