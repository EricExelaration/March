import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ));
     //   driver.get( "https://www.hoteltonight.com/" );
        driver.get( "https://www.facebook.com/" );
        Thread.sleep( 1000 );

     // driver.findElement( By.xpath("royal_login_button")).click();
       // System.out.println( driver.findElement( By.xpath("//h1[text()='Incredible last-minute hotel deals']") ) );

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
        // driver.get""
      driver.findElement(By.cssSelector("#email")).sendKeys("email@gmail.com");
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("pass");
       driver.findElement(By.cssSelector("//input[@placeholder='Password']")).sendKeys("pass123");
        driver.findElement(By.cssSelector("//button[id^=u_0_5_Es]")).click();

    }
}