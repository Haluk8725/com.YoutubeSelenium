package İnstagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class CallfriendTExt {

    public static void main(String[] args) throws InterruptedException {
        Scanner input=new Scanner(System.in);
        System.out.println("Please give your password");
        String password1=input.next();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.instagram.com/");
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"));
        username.sendKeys("haluk.ural");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"));
        password.sendKeys(password1, Keys.ENTER);
        Thread.sleep(5000);
        driver.get("https://www.instagram.com/haluk.ural/");
        Thread.sleep(5000);
        driver.get("https://www.instagram.com/haluk.ural/followers/");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll = driver.findElement(By.className("_aano"));
        String result = driver.findElement(By.xpath("//span[@title=\"57\"]")).getText();
        System.out.println(result);
        int elementsize = 0;

        List<WebElement> elements;
        while (true) {
            js.executeScript("arguments[0].scrollBy(0,arguments[0].scrollHeight)", scroll);
            elements = driver.findElements(By.cssSelector("._ab8y._ab94._ab97._ab9f._ab9k._ab9p._abcm"));
            elementsize = elements.size();
            if (result.equals(elementsize + "")) break;
            Thread.sleep(3000);
        }
        int a = 1;
        for (WebElement element : elements) {
            System.out.println(a + "-" + element.getText());
            a++;
        }
    }
}


