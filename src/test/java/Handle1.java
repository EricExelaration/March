import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Handle1 {



    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        // Thread.sleep( 2000 );

        driver.get( "https://www.cars.com/" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );

        driver.findElement( By.linkText( "Grow with CARS" ) ).click();

        // driver.findElement(  )
        String windowHandleOfCarsCom = driver.getWindowHandle();
        System.out.println("The first window handle: " + windowHandleOfCarsCom);
        String allWindowHandleOfCarsCom = driver.getWindowHandle();
        System.out.println("The all window handle: " + allWindowHandleOfCarsCom);

        Set<String> windowHandles = driver.getWindowHandles();

        for(String windowHandle: windowHandles){

                driver.switchTo().window( windowHandle);
                if(driver.getTitle().equals( "let's Grow Your Dealership ROI | GrowWithCars.com" )){
                    break;

            }

        }
        System.out.println("the current url is:" + driver.getCurrentUrl());

    }
}