package March.RegregionTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests {


    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }


    WebDriver driver;
    @BeforeMethod
    public void setUpEachMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void testLogin(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.className("button")).click();
        Assert.assertEquals(driver.getTitle(), "Web Order");


    }

    @Test
    public void testLogin2(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("");
        driver.findElement(By.className("button")).click();
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");


    }

    @Test
    public void testLogin3(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.className("button")).click();
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");


    }

    @Test
    public void testLogin4(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("");
        driver.findElement(By.className("button")).click();
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");


    }
}