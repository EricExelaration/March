import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttirbute {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));

        System.out.println(searchBox = driver.findElement(By.name("maxLength")));
        //System.out.println(driver.findElement(By.name("hero-table-intro")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("hero-table-intro")).getText());
        //list<WebElement>links = driver.findElement(By.name("a"));


    }
}