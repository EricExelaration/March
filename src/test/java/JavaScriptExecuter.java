import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptExecuter {



    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        // Thread.sleep( 2000 );

        driver.get( "https://www.cars.com/" );
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );

        //WebElement inputBox = driver.findElement( By.id( "make-model-search-stocktype" ) );
       // WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 5 ) );
      //  wait.until( ExpectedConditions.elementToBeClickable(inputBox) );
       // Select select = new Select(usedDropDownBox);
        //select.selectByVisibleText( "Used" );

    //    new Select( driver.findElement(By.id( "makes" )) ),selectByValue("Lamborghini");



      //  driver.findElement( By.id( "make-model-zip" ) ).click();
       driver.findElement( By.id( "make-model-zip" ) ).sendKeys( "22031" , Keys.ENTER );
        driver.findElement( By.id( "model Lamborghini-400_gt" ) ).click();
     //   JavaScriptExecuter js = (JavaScriptExecuter) driver;
    //    js.executeScript("arguments[0].click();", checkbox);

      // SeleniumUtilities.jsClick(driver)
    }

    public void executeScript(String s) {

    }
}