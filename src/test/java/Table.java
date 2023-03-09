import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class table {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get( "https://coinmarketcap.com/" );
        driver.manage().window().maximize();
        driver.manage();

        int columnCount = driver.findElements( By.xpath( "//table//thead//th" ) ).size();
        int rowCount = driver.findElements( By.xpath( "//table//tbody//tr" ) ).size();


        System.out.println( "int columnCount:" + columnCount);
        System.out.println( "int rowCount:" +rowCount);
        Thread.sleep(3000);

        for(int i= 1; i<=rowCount; i++){
            for(int j = 1; j<= columnCount; j++){
                String xpath = "//table//tbody//tr["+i+"]//td["+j+"]";
                System.out.println(driver.findElement( By.xpath( xpath ) ).getText()+"\t");

                List<WebElement> crytoNames = driver.findElements( By.xpath( "//table//tbody//tr//td[3]" ) );

                for (int z= 1; z<=10; z++){
                    System.out.println(crytoNames.get(z).getText());
            }

            }

        }



    }

}
