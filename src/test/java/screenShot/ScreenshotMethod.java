package screenShot;

import Utilities.Utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotMethod {
    public static void main(String[] args) throws IOException {
        WebDriver driver= Utilities.start();
        driver.get("https://www.ebay.com");
        File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\haluk\\IdeaProjects\\com.YoutubeSelenium\\src\\test\\java\\screenshoot/screen.png") );
    }
}
