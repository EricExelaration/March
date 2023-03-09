import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

    public class SDET {
        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();


            driver.get("https://www.dice.com/");
            Thread.sleep(1000);

            driver.findElement(By.id("typeaheadInput")).sendKeys("SDET",Keys.TAB,Keys.TAB,"Arlington, VA" , Keys.ENTER, Keys.ENTER );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException( "List is empty");
            }
           driver.findElement(By.id("submitSearch-button")).click();


            List<WebElement> resultLinks = By.xpath("card-title-link bold").findElements( driver );


            for (WebElement link : resultLinks) {
                String linkText = link.getText();
                if (!linkText.contains("SDET")) {
                    System.out.println("FAIL: Link text does not contain SDET: " + linkText);
                }
            }


            driver.quit();
        }
    }


