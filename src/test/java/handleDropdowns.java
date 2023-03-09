import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class handleDropdowns {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );
        driver.manage().window().maximize();
        driver.get( "https://www.cars.com/" );

        // make-model-max-price
        WebElement usedDropDownBox = driver.findElement( By.id( "make-model-search-stock type" ) );

        Select select = new Select( usedDropDownBox );
        select.selectByVisibleText( "New" );

        //new Select( driver.findElement(By.id( "models") )).selectByVisibleText( "No max price" );//
        // new Select( driver.findElement(By.id( "make-model-maximum-distance") )).selectByVisibleText( "100 miles" );


        driver.findElement( By.id( "make-model-zip" ) ).sendKeys( "22031", Keys.ENTER );

       // List<String> expectedValues = List.of( "New and certified", "New", "Used" );
       // List<WebElement> options = new Select( driver.findElement( By.id( "make-model-search-stock type" ) ) ).getOptions();

       // for (WebElement option : options) {
        //    System.out.println( option.getText() );
        }
    }



