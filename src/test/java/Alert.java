import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Alert {


    public static void main(String[] args) {


        WebDriver driver = new EdgeDriver();

       // Thread.sleep( 2000 );

        driver.get( "https://the-internet.herokuapp.com/javascript_alerts" );
        driver.manage().window().maximize();
        driver.manage();
        driver.findElement( By.linkText( "Elemential Selenium" ) ).click();
        driver.findElement( By.xpath("//button[.Click for JS Confirm']")  ).click();

       
    }
}