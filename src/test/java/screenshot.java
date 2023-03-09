import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class screenshot {

    private static Object SeleniumUtilities;

    public static void main(String[] args) throws IOException {


        WebDriver driver = new ChromeDriver();

        // Thread.sleep( 2000 );

        driver.get( "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );

        driver.findElement( By.id( "ctl00_MainContent_username" ) ).sendKeys( "Tester", Keys.TAB, "test", Keys.ENTER );

        try {
            Assert.assertEquals( driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx" );
        } catch (AssertionError e) {

            byte[] screenshotAsFiles = ((TakesScreenshot) driver).getScreenshotAs( OutputType.BYTES );
       // SeleniumUtilities.takeScreenshot(driver,"src/test/java/march1/screenshots/image.jpeg");
            Files.write( Path.of( "screenshot"+System.currentTimeMillis()+".phg"  ), screenshotAsFiles );
            throw e;
        }
    }
}