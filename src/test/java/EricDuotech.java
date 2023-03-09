import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
public class EricDuotech {



    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();


        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        // Step 2: Verify the page title
        String expectedTitle = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Step 3: Click on Signup here
        WebElement signupLink = driver.findElement(By.linkText("Signup here"));
        signupLink.click();

        // Step 4: Fill out the form with the required info using Faker class
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String username = faker.name().username();
        String password = faker.internet().password();
        String day = Integer.toString(faker.number().numberBetween(1, 28));
        String month = Integer.toString(faker.number().numberBetween(1, 12));
        String year = Integer.toString(faker.number().numberBetween(1900, 2022));

        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        WebElement dayField = driver.findElement(By.name("day"));
        dayField.sendKeys(day);

        WebElement monthField = driver.findElement(By.name("month"));
        monthField.sendKeys(month);

        WebElement yearField = driver.findElement(By.name("year"));
        yearField.sendKeys(year);

        // Step 5: Click on Sign up
        WebElement signUpButton = driver.findElement(By.name("submit"));
        signUpButton.click();

        // Step 6: Verify the URL after logging in
        String expectedUrl = "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Step 7: Verify the name on the left navigation bar
        WebElement nameLink = driver.findElement(By.cssSelector("a[href='user_details.php']"));
        String expectedName = firstName + " " + lastName;
        String actualName = nameLink.getText();
        Assert.assertEquals(actualName, expectedName);

        // Step 8: Verify the name on the main window
        nameLink.click();
        WebElement nameElement = driver.findElement(By.cssSelector("div#name>h1"));

    }

}
