import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class test {
    public static void main(String[] args){
        System.out.println("Testing");
        //Assert.assertEquals(12,23);
        Faker faker = new Faker();

        System.out.println(faker.address().firstName());
        System.out.println(faker.address().lastName());
        System.out.println(faker.address().streetAddress());


        System.out.println(faker.chuckNorris().fact());
        WebDriver driver = new ChromeDriver();
    }
}
