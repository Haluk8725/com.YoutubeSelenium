package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestNotations {
     WebDriver driver;

    @Before
    public  void setting(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void lastFacialty(){
        driver.close();
    }
    @Test
    public void test01(){
         driver.get("https://www.amazon.com");
    }
    @Test
    public void test02(){
        driver.get("https://cydeo.com/");
        System.out.println("Page title :"+driver.getTitle());}
    @Test
    public void test03(){
        driver.get("https://www.w3schools.com/");
        System.out.println("Page url :"+driver.getCurrentUrl());

    }
}

