package İnstagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CallfriendTExt {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.instagram.com/");
        Thread.sleep(2000);
        WebElement username= driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"));
        username.sendKeys("haluk.ural");
        WebElement password=driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"));
        password.sendKeys("haluk8725", Keys.ENTER);
        Thread.sleep(3000);
        driver.get("https://www.instagram.com/haluk.ural/"); Thread.sleep(2000);
       driver.get("https://www.instagram.com/haluk.ural/followers/");
        Thread.sleep(2000);
        List<WebElement> elements=driver.findElements(By.cssSelector("._ab8y._ab94._ab97._ab9f._ab9k._ab9p._abcm"));
        int i=1;
        for (WebElement element : elements) {
            System.out.println(i+"-"+element.getText());
            i++;
        }

    }
}
