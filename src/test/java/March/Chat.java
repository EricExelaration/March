package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Chat {

    

    public void fileUploadTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));

        driver.get("the-internet.herokuapp.com/upload");
            String absolutPathDynamic = System.getProperty( "user.dir" )+"/src/test/java/March/Chat.txt";
            driver.findElement( By.id("file-upload") ).sendKeys( System.getProperty( "user.dir" ) +"\\src\\test\\java\\March\\chat.txt");
            driver.findElement( By.id( "file-submit" ) ).click();
    }
}
