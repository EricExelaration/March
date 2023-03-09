import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DuotifyTest {
    private WebDriver driver;
    private String baseUrl;
    private Faker faker;

    @BeforeClass
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        baseUrl = "http://duotify.us-east-2.elasticbeanstalk.com/";
        faker = new Faker();
       // driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 5 ) );
    }

    @Test(priority = 1)
    public void testHomePageTitle() {
        driver.get( baseUrl + "register.php" );
        String expectedTitle = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals( actualTitle, expectedTitle );
    }

    @Test(priority = 2)
    public void testSignUp() {
        driver.findElement( By.linkText( "Signup here" ) ).click();
        driver.findElement( By.name( "firstName" ) ).sendKeys( faker.name().firstName() );
        driver.findElement( By.name( "lastName" ) ).sendKeys( faker.name().lastName() );
        driver.findElement( By.name( "email" ) ).sendKeys( faker.internet().emailAddress() );
        driver.findElement( By.name( "password" ) ).sendKeys( faker.internet().password() );
        driver.findElement( By.name( "password2" ) ).sendKeys( faker.internet().password() );
        driver.findElement( By.name( "register" ) ).click();
        String expectedUrl = baseUrl + "browse.php?";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals( actualUrl, expectedUrl );
    }

    @Test(priority = 3)
    public void testVerifyNameOnNavigationBar() {
        WebElement navigationBar = driver.findElement( By.id( "navBar" ) );
        String expectedName = navigationBar.findElement( By.className( "nav" ) ).getText();
        String[] nameParts = expectedName.split( " " );
        String expectedFirstName = nameParts[0];
        String expectedLastName = nameParts[1];
        String actualFirstName = driver.findElement( By.id( "firstNameText" ) ).getText();
        String actualLastName = driver.findElement( By.id( "lastNameText" ) ).getText();
        Assert.assertEquals( actualFirstName, expectedFirstName );
        Assert.assertEquals( actualLastName, expectedLastName );
    }

    @Test(priority = 4)
    public void testVerifyNameOnMainWindow() {
        WebElement navigationBar = driver.findElement( By.id( "navBar" ) );
        navigationBar.findElement( By.className( "nav-link" ) ).click();
        String expectedName = navigationBar.findElement( By.className( "nav" ) ).getText();
        String[] nameParts = expectedName.split( " " );
        String expectedFirstName = nameParts[0];
        String expectedLastName = nameParts[1];
        String actualFirstName = driver.findElement( By.id( "firstName" ) ).getAttribute( "value" );
        String actualLastName = driver.findElement( By.id( "lastName" ) ).getAttribute( "value" );
        Assert.assertEquals( actualFirstName, expectedFirstName );
        Assert.assertEquals( actualLastName, expectedLastName );
        driver.findElement( By.linkText( "Logout" ) ).click();
    }

    @Test(priority = 5)
    public void testLogin() {
        driver.findElement( By.name( "username" ) ).sendKeys( faker.internet().emailAddress() );
        driver.findElement( By.name( "password" ) ).sendKeys( faker.internet().password() );
        driver.findElement( By.name( "login" ) ).click();
        Assert.assertTrue( driver.getPageSource().contains( "You Might Also Like" ) );
    }

    @Test(priority = 8)
    public void testLogoutAgain() {
        driver.findElement( By.linkText( "Logout" ) ).click();
        String expectedUrl = baseUrl + "register.php";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals( actualUrl, expectedUrl );
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}