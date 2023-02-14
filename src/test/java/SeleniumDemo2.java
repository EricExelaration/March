import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo2 {

        public static void main(String[] args){

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");

            WebElement searchBox = driver.findElement(By.name("q")); // name buttanii ner ni q baisan

            String searchTerm = "chatGPT";
            String expectedTitle= searchTerm+ " Google Search";
            searchBox.sendKeys(searchTerm, Keys.ENTER);

            String actualTitle = driver.getTitle()+"RandomWord";


            if(actualTitle.equals(expectedTitle)) {
                System.out.println("Test passed");
            }else{
                System.out.println("Test failed. The current title is " + actualTitle+ "The expected was "+ expectedTitle );
            }
        }
    }


