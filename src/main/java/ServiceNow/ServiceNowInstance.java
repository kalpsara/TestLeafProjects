package ServiceNow;

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ServiceNowInstance {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://developer.servicenow.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Shadow dom = new Shadow(driver);
        //List<WebElement> signUpElements =  dom.findElementsByXPath("//a[@href='https://signon.service-now.com/x_snc_sso_auth.do#/sign-up?appId=APP0001037']");
        //dom.findElementByXPath("//h1[contains(text(),'Build apps that solve business')]/following-sibling::dps-link").click();
        //List<WebElement> signUpElements = dom.findElementsByXPath("//dps-link[contains(text(),'Sign up and Start Building')]");
        //signUpElements.get(0).click();
        dom.findElementByXPath("//dps-link[contains(text(),'Sign up and Start Building')]").click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dom.findElementByXPath("//dps-link[contains(text(),'Sign up and Start Building')]").click();

        //signUpElements.get(0).findElement(By.xpath(".///a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("firstName")).sendKeys("Kalpana");
        driver.findElement(By.id("lastName")).sendKeys("Saravanakumar");
        driver.findElement(By.id("email")).sendKeys("venkatraman.kalpana@gmail.com");
        driver.findElement(By.id("country")).sendKeys("IN");
        driver.findElement(By.id("password")).sendKeys("Servicenow100*");
        driver.findElement(By.id("confirmPassword")).sendKeys("Servicenow100*");

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(frameElement);
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();


    }
}
