package Automatoin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkSelenium {
    WebDriver driver;
   @BeforeMethod
    public void setBrowser() {
        String chromeDriverPath = "browserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }
    @Test
    public void searchWeb() throws InterruptedException {

        // search box:
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Laptop");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        //verify logo
        String ExpectedResult = "PC Laptops & Netbooks";
        String ActualResult = driver.findElement(By.xpath("//*[@id=\"x-refine__group__0\"]/ul/li/ul/li[2]/ul/li[1]/span")).getText();
//     Assert.assertEquals(ActualResult,ExpectedResult, "Test fail");
        //Price
        driver.findElement(By.xpath("//*[@id=\"s0-14-11-6-3-query_answer1-answer-2-1-0-list\"]/li[1]/div/a/div")).click();
        Thread.sleep(5000);
        String ExpectedResult1 = ("32 GB");
        String ActualResult1 = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div[1]/div[2]/ul/div[1]/div/div/div/div/div/ul/li[4]/div/a/div")).getText();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div[1]/div[2]/ul/div[1]/div/div/div/div/div/ul/li[4]/div/a/div")).click();
        //Assert.assertEquals(ActualResult,ExpectedResult, "Test fail");
        if (ExpectedResult1.equalsIgnoreCase(ActualResult1)) {
            System.out.println("Ram size test pass");
        } else {
            System.out.println("Ram size test fail");
        }
        //Wait 5 seconds
        Thread.sleep(5000);

        String ExpectedResult2 = "Screen Size";
        String ActualResult2 = driver.findElement(By.xpath("//*[@id=\"s0-14-11-0-1-2-6\"]/li[1]/ul/li[2]/ul/li[2]/div[1]/h3")).getText();
        driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__2\"]/ul/li[4]/div/a/div/span/input")).click();

        String ExpectedResult3 = "Operating System";
        String ActualResult3 = driver.findElement(By.xpath("//*[@id=\"s0-14-11-0-1-2-6\"]/li[1]/ul/li[2]/ul/li[3]/div[1]/h3")).getText();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[5]/div[4]/ul/li[1]/ul/li[2]/ul/li[3]/div[2]/ul/li[1]/div/a/div/span/input")).click();
        driver.navigate().back();
//        driver.navigate().forward();
    }
//     @AfterMethod
//     public void closeBrowser()
//     {driver.close();}
}




