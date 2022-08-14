package video5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TrendyolTask {

    @Test
        public  void setting(){
            WebDriverManager.chromedriver().setup();
            WebDriver  driver=new ChromeDriver();
            driver.manage().window().maximize();
         //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.trendyol.com");
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
            WebElement search1=driver.findElement(By.xpath("//input[@class='search-box']"));
            search1.sendKeys("Bisiklet");
        driver.findElement(By.xpath("//input[@class='search-box']")).submit();
          // driver.findElement(By.xpath("//*[@id=\"auto-complete-app\"]/div/div/i")).click();
            WebElement result=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[1]/div"));

            String actualresult=result.getText();
        Assert.assertTrue(actualresult.contains("Disiklet"));
            if(actualresult.contains("Bisiklet"))
                System.out.println("Trendyol test passed");
            else System.out.println("Trendyol test failed");

            driver.close();
        }


}
