package video3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AmazonTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.tr");
        WebElement srch=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        srch.sendKeys("Nutella");
        srch.submit();
        WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
    }
}
