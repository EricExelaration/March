public class locatebylinktext {

   package february15;
​
        import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
​
        import java.util.List;
​
    public class LocateByLinkText {
​
        ​
        public static void main(String[] args) {
​
​
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
​
//        driver.findElement(By.linkText("Images")).click();
//
//        Assert.assertEquals(driver.getTitle(), "Google Images");
​
//        driver.findElement(By.linkText("Business")).click();
//
//        Assert.assertEquals(driver.getTitle(), "Google for Small Business - Resources to get your small business online");
​
​
            driver.findElement(By.partialLinkText("How Search")).click();
//
            Assert.assertEquals(driver.getTitle(), "Google Search - Discover How Google Search Works");
​
​
​
​
        }
    }
}
