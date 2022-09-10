package Twitter;

import Utilities.ConfigurationReader;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Twitter {
    WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @Test
    public void twitter() throws InterruptedException {


        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();
        WebElement username = driver.findElement(By.xpath("//input[@autocapitalize='sentences']"));
        username.sendKeys(ConfigurationReader.getProperty("username"), Keys.ENTER);
        WebElement username1 = driver.findElement(By.tagName("input"));
        username1.click();

        username1.sendKeys(ConfigurationReader.getProperty("second"), Keys.ENTER);
        WebElement password = driver.findElement(By.xpath(" //input[@autocomplete='current-password']"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        WebElement showAll = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[2]/div/div[2]/div/div/div/div[3]/div/section/div/div/div[13]/div/a/div/span"));
        showAll.click();
        List<WebElement> topics = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-16y2uox r-bnwqim']//div[2]/span"));

        for (int i = 0; i < topics.size(); i++) {
            topics = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-16y2uox r-bnwqim']//div[2]/span"));
            System.out.println(topics.size());
            Thread.sleep(5000);
            try {
                System.out.println(topics.get(i).getText());
            } catch (RuntimeException e) {
               e.printStackTrace();
            }
            trollHunter(topics.get(i));


        }

    }

    public void trollHunter(WebElement topic) throws InterruptedException {
        topic.click();
        driver.findElement(By.xpath("//span[.='Latest']")).click();
        Thread.sleep(5000);
        List<WebElement> username = driver.findElements(By.xpath("//div[@data-testid='User-Names']/div/div/a"));
        for (WebElement element : username) {
            System.out.println(element.getAttribute("href"));
        }
        driver.navigate().back();


    }


}
//tweetText