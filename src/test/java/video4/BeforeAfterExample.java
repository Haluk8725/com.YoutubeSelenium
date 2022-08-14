package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeAfterExample {
    static WebDriver driver;

    @BeforeClass
    public static void setting(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void lastFacialty(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02(){
        System.out.println("Page title :"+driver.getTitle());}
    @Test@Ignore
        public void test03(){
     System.out.println("Page url :"+driver.getCurrentUrl());

    }
}
