package week6.day2.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lead  extends LeadBase {
    @Test(dataProvider = "dataProvider",priority = -3,invocationCount=2,enabled=false)
    public void createLead(String... data) {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys(data[0]);
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys(data[1]);
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys(data[2]);
        driver.findElement(By.name("submitButton")).click();

    }

    @Test(dataProvider = "dataProvider",priority = -2,enabled=false,dependsOnMethods={"createLead"})
    public  void editLead(String... data) throws InterruptedException {

        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
        driver.findElement(By.name("submitButton")).click();

    }
    @Test(dataProvider = "dataProvider",priority = -1,enabled=false,dependsOnMethods={"createLead"})
    public  void duplicateLead(String... data) throws InterruptedException {

        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.findElement(By.linkText("Duplicate Lead")).click();
        driver.findElement(By.name("submitButton")).click();

    }


    @Test(dataProvider = "dataProvider",dependsOnMethods={"createLead","editLead"})
    public void mergeLead(String... data) throws InterruptedException {

        driver.findElement(By.linkText("Merge Leads")).click();
        driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
        Set<String> allWindows = driver.getWindowHandles();
        List<String> allhandles = new ArrayList<String>(allWindows);
        driver.switchTo().window(allhandles.get(1));
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("kalpana");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(1000);
        String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.switchTo().window(allhandles.get(0));

        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        Set<String> allWindows2 = driver.getWindowHandles();
        List<String> allhandles2 = new ArrayList<String>(allWindows2);
        driver.switchTo().window(allhandles2.get(1));
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("ef");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.switchTo().window(allhandles2.get(0));
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        String text = driver.findElement(By.className("x-paging-info")).getText();
        if (text.equals("No records to display")) {
            System.out.println("Text matched");
        } else {
            System.out.println("Text not matched");
        }



    }
    @Test(dataProvider = "dataProvider",priority = 1,enabled=false,dependsOnMethods={"createLead"})
    public  void deleteLead(String... data) throws InterruptedException {

        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.findElement(By.linkText("Delete")).click();
        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        String text = driver.findElement(By.className("x-paging-info")).getText();
        if (text.equals("No records to display")) {
            System.out.println("Text matched");
        } else {
            System.out.println("Text not matched");
        }

    }
    @BeforeTest
    private void setFileName() {

        setFileName("Lead.xlsx");

    }
}
