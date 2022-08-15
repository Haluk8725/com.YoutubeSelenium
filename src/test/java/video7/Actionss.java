package video7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionss {

@Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        WebElement signUpLink=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
       Actions actions= new Actions(driver);
       actions.click(signUpLink).perform();
       WebElement namebox=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
       actions.click(namebox)
               .sendKeys("haluk1152653")
               .sendKeys(Keys.TAB)
               .sendKeys("a@bc56defkd.com")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER)
               .perform();
       WebElement radioButton=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[1]/div[1]/label"));
       actions.click(radioButton)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("12345")
               .sendKeys(Keys.TAB)
               .sendKeys("1")
               .sendKeys(Keys.TAB)
               .sendKeys("March")
               .sendKeys(Keys.TAB)
               .sendKeys("1985")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("lsdfj")
               .sendKeys(Keys.TAB)
               .sendKeys("şlfk")
               .sendKeys(Keys.TAB)
               .sendKeys("ali")
               .sendKeys(Keys.TAB)
               .sendKeys("ljfgljlkfdjsdf fdasdf")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("Turkey")
               .sendKeys(Keys.TAB)
               .sendKeys("İstanbul")
               .sendKeys(Keys.TAB)
               .sendKeys("Başakşehir")
               .sendKeys(Keys.TAB)
               .sendKeys("334446")
               .sendKeys(Keys.TAB)
               .sendKeys("123315646")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER)
               .perform();
       String expect="ACCOUNT CREATED!";
       String actual=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
    Assert.assertEquals(expect,actual);







    }
}
