import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollDown {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        // Thread.sleep( 2000 );

        driver.get( "https://www.amazon.com/" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );

        JavaScriptExecuter js = (JavaScriptExecuter) driver;
        js.executeScript("document.getElementById('twotabsearchtextbox').value='cofee';");
        js.executeScript("window.scrollBy(0,2000)");

    }
}
