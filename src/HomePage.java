import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    public static void main(String[] args) throws InterruptedException {

        String chromeDriverPath="browserDriver\\windows\\chromedriver.exe";
      //String chromeDriverPath= "C:\\Users\\mahbu\\IdeaProjects\\learnAutomation\\browserDriver\\windows\\chromedriver_win32\\chromedriver.exe";
        // set up browser
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


        // navigate to url
        // WebDriver driver;
        Thread.sleep(5000);

        //driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Hand Sanitizer");
         Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        //verify expected result and actual result match
        String expectedResult="\"Hand Sanitizer\"";
        String actualResult=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();

        if (expectedResult.equalsIgnoreCase(actualResult)){
            System.out.println("test pass");

        }else{
            System.out.println("test fail");
        }

        String expectedResult1="Amazom.com : Hand Sanitizer";
        String actualResult1=driver.getTitle();
        if (expectedResult1.equalsIgnoreCase(actualResult1)){
            System.out.println(" test title pass");
        }else{
            System.out.println("test title fail");
        }

        String expectedResult2="Purell Advanced Hand Sanitizer Naturals with Plant Based Alcohol, Citrus Scent, 12 fl oz Pump Bottle (Pack of 4) - 3623-06-EC2";
        String actualResult2=driver.findElement(By.xpath("  " + "  ")).getText();
        driver.findElement(By.xpath("    ")).click();
        if (expectedResult2.equalsIgnoreCase(actualResult2));

         Thread.sleep(5000);
         driver.close();


    }

}
