package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println("Page title :"+driver.getTitle());
        System.out.println("---------------------------");

        System.out.println("Page source code"+driver.getPageSource());
        System.out.println("=============================");
        System.out.println(driver.getWindowHandle());
//        System.out.println(driver.getWindowHandles());

    }
}
