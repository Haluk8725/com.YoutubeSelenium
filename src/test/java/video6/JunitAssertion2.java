package video6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JunitAssertion2 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://automationexercise.com");
        WebElement logoElement=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
        Assert.assertTrue(logoElement.isDisplayed());
        WebElement product=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        product.click();
        String expectUrl="https://automationexercise.com/products";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectUrl,actualUrl);
        WebElement srch= driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        srch.sendKeys("Men Tshirt");
        driver.findElement(By.xpath("//*[@id=\"submit_search\"]/i")).click();
        WebElement doneSrc=driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
        Assert.assertTrue(doneSrc.isDisplayed());

        driver.close();
    }
}