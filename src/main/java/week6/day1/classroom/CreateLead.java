package week6.day1.classroom;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import week5.day1.assignments.LeadBase;


public class CreateLead extends LeadBase {

    @Test(dataProvider = "sendData")
    public void createLeadTest(Object cname, Object fname, Object lname) {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname.toString());
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname.toString());
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname.toString());
        driver.findElement(By.name("submitButton")).click();

    }


    @DataProvider
    public Object[][] sendData() {
        String strArray[][] = new String[2][3];
        strArray[0][0] = "testleaf";
        strArray[0][1] = "kalp";
        strArray[0][2] = "sara";

        strArray[1][0] = "paypal";
        strArray[1][1] = "krithi";
        strArray[1][2] = "kalps";

        return strArray;
    }
}






