package week6.day2.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import week6.day2.assignments.LeadBase;


public class CreateLead extends LeadBase {

    @Test(priority = -3)
    public void createLeadTest() {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kalpana");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Venkatraman");
        driver.findElement(By.name("submitButton")).click();

    }
}






