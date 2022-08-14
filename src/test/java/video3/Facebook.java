package video3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Facebook {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        WebElement srch=
                driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        srch.sendKeys("ldfjfldfjdal");
        WebElement key=driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        key.sendKeys("jdlfjasljfkl");
      driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")).click();
      WebElement result=driver.findElement(By.xpath("//div[@class='_9ay7']"));
      String expectResult="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
      String actualResult=result.getText();
      if(expectResult.equals(actualResult)){
          System.out.println("Test of enter passed");
      }else System.out.println("Test of enter fail");
      driver.close();
    }
}


