import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Iframe {
    public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();

    // Thread.sleep( 2000 );


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get( "https://www.duotech.io/enroll-sqae2" );
 driver.findElement(By.xpath("input[@placeholder='First']")).sendKeys("Erick");


        WebElement iframeElement =driver.findElement( By.xpath( "//iframe[starts-with(@id, '167')]" ) );
        driver.switchTo().frame( iframeElement );

        driver.switchTo().defaultContent();
        driver.findElement( By.xpath( "//input[@placeholder='First']" ) ).sendKeys( "Erick" );
        WebElement lmsLink =  driver.findElement( By.linkText( "LMS" ) );
        ((JavascriptExecutor)driver).executeScript( "arguments[0].click();",  lmsLink);
driver.switchTo().parentFrame();
}
}