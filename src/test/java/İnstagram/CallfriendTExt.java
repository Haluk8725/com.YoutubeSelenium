package İnstagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CallfriendTExt {

    public static void main(String[] args) throws InterruptedException, IOException {
        FileWriter writer=new FileWriter("C:\\Users\\haluk\\Desktop\\Takipci.txt");

        Scanner input=new Scanner(System.in);
        System.out.println("Please give your password");
        String password1=input.next();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.instagram.com/");

        WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"));
        username.sendKeys("haluk.ural");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"));
        password.sendKeys(password1, Keys.ENTER);
        driver.get("https://www.instagram.com/haluk.ural/");
        driver.get("https://www.instagram.com/haluk.ural/followers/");

        WebElement scroll = driver.findElement(By.className("_aano"));
        String result = driver.findElement(By.xpath("//span[@title=\"57\"]")).getText();
        System.out.println(result);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int elementsize = 0;
        List<WebElement> elements;
        while (true) {
            js.executeScript("arguments[0].scrollBy(0,arguments[0].scrollHeight)", scroll);
            elements = driver.findElements(By.cssSelector("._ab8y._ab94._ab97._ab9f._ab9k._ab9p._abcm"));
            elementsize = elements.size();
            if (result.equals(elementsize + "")) break;
                   }
        int a = 1;
        for (WebElement element : elements) {
            System.out.println(a + "-" + element.getText());
            a++;
            writer.write(element.getText()+"\n");
        }
        writer.close();
        driver.close();
    }
}


