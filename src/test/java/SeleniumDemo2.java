import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class SeleniumDemo2 {

        public static void main(String[] args){

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
            String expectedTitle = "Welcome to Duotify!";
            String actualTitle = driver.getTitle();

            WebElement searchBox = driver.findElement(By.name("Signup here"));
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String username = firstName.toLowerCase() + lastName.toLowerCase() + faker.random().nextInt(10000);
            String password = faker.internet().password();
            WebElement firstNameInput = driver.findElement(By.name("first_name"));
            WebElement lastNameInput = driver.findElement(By.name("last_name"));
            WebElement usernameInput = driver.findElement(By.name("uid"));
            WebElement passwordInput = driver.findElement(By.name("password"));
            firstNameInput.sendKeys(firstName);
            lastNameInput.sendKeys(lastName);
            usernameInput.sendKeys(username);
            passwordInput.sendKeys(password);

            driver.findElement(By.name("signup")).click();

          
            driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );
            driver.get("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");
            String loggedInUrl = driver.getCurrentUrl();
            WebElement signupButton = driver.findElement(By.cssSelector("button[type='submit']"));
            signupButton.click();



           }
        }



