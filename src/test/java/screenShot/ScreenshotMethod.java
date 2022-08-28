package screenShot;

import Utilities.Utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotMethod {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver= Utilities.start();
        driver.get("https://www.ebay.com");
        File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\haluk\\IdeaProjects\\com.YoutubeSelenium\\src\\test\\java\\screenshoot/screen.png") );
        Thread.sleep(2000);
        WebElement apple= driver.findElement(By.xpath("//*[@id=\"destinations_list1\"]/ul/li[1]/a/div/div/div"));
        apple.click();
        WebElement title= driver.findElement(By.cssSelector("h1.title-banner__title"));
        String name=title.getText();
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\haluk\\IdeaProjects\\com.YoutubeSelenium\\src\\test\\java\\screenshoot\\"+name+".png") );
        driver.quit();
    }
}
