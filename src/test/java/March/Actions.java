package March;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Actions {


    public static void main(String[] args) {
    //public void fileUploadTest() throws AWTException {
 
    

    WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Action(WebDriver.driver);
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));

        driver.get("the-internet.herokuapp.com/");


    }

}