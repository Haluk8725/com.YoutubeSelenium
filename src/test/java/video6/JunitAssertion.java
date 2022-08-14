package video6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JunitAssertion {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://automationexercise.com");
        WebElement logoElement=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
        Assert.assertTrue(logoElement.isDisplayed());
        WebElement signUpLink=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLink.click();
        WebElement accounVery= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
         Assert.assertTrue(accounVery.isDisplayed());
         WebElement email=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
         email.sendKeys("ahmet@nehaber.com");
       WebElement password=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        //password.submit();
        WebElement button=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        button.click();
        WebElement login=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
       // System.out.println(login.getText());
        Assert.assertTrue(login.isDisplayed());
       WebElement logout= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        logout.click();
        String expectUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectUrl,actualUrl);
        driver.close();
    }
}
