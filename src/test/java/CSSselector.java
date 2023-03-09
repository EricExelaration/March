import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

    public class CSSselector {

    @Test
    public void testingDice() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.facebook.com/");

        System.out.println( driver.findElement(By.cssSelector("body div div div")).getSize());

        //#email

        // absolute css selector path  -> body div div div

        // Using class   ->  . in css means class
        //  input.inputtext   -> input element with class inputtext
        // input.inputtext._55r1._6luy -> input element with multiple classes

        // Using an id -< in css id is #
        // input#email -> input element with an id 'email'
        //#email -> any element with an id email

        driver.findElement(By.cssSelector("#email")).sendKeys("email@gmail.com");
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("pass");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("pass123");

        //Using 2 attributes in css   ->   input[placeholder='Password'][data-testid='royal_pass']

    }
}