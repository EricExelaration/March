
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WarmUp {


    @Test
    public void warmUP() throws InterruptedException {


            // Navigate to instagram.com
            WebDriver wb = new ChromeDriver();
            wb.get("https://www.instagram.com/");
            Thread.sleep(500);
            // Enter wrong credentials for username and password (minnie.mouse, minnie)
            wb.findElement(By.name("username")).sendKeys(new Faker().name().username());
            // NoSuchElementException: no such element: Unable to locate element
            wb.findElement(By.name("password")).sendKeys(new Faker().internet().password(), Keys.ENTER);

            // Verify that the error message "Sorry, your password was incorrect. Please double-check your password." is on the page
            Thread.sleep(1000);
            Assert.assertEquals(wb.findElement(By.id("slfErrorAlert")).getText(),"Sorry, your password was incorrect. Please double-check your password.");

            wb.quit();



        }
    }