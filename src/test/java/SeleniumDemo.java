import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q")); // name buttanii ner ni q baisan

        String searchTerm = "chatGPT";
        searchBox.sendKeys(searchTerm, Keys.ENTER);
        String currentTitle = driver.getTitle();


        if(currentTitle.contains(searchTerm)) {
        }else{
                System.out.println("Test passed");
            }
        }
    }






