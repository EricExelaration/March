import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class createWebOrder {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.className("button")).click();
        Assert.assertEquals(driver.getTitle(), "Web Order");


       driver.findElement(By.linkText("Order")).click();


        int quantity = (int) (Math.random() * 100) + 1;
        WebElement quantityField = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityField.sendKeys(Integer.toString(quantity));


        WebElement calculateButton = driver.findElement(By.cssSelector("input[value='Calculate']"));
        calculateButton.click();
        WebElement totalPriceField = driver.findElement(By.id("ctl00_MainContent_fmwOrder_lblTotal"));
        double expectedTotal = 100.0 * quantity * (quantity >= 10 ? 0.92 : 1.0);
        double actualTotal = Double.parseDouble(totalPriceField.getText().replace("$", ""));
        if (expectedTotal == actualTotal) {
            System.out.println("Total price is correct: " + actualTotal);
        } else {
            System.out.println("Total price is incorrect: expected " + expectedTotal + ", but got " + actualTotal);
        }


        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(firstName + " " + lastName);
        System.out.println(faker.chuckNorris().fact());

        String streetAddress = faker.address().streetAddress();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("1600");

        String city = faker.address().city();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Arlington");

        String state = faker.address().stateAbbr();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("VA");


        String zipCode = faker.address().zipCode().substring(0, 5);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("22209");


        driver.quit();
    }
}