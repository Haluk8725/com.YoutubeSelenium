package amazonApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends Main{
    By addToCartButtonLocator=By.id("submit.add-to-cart");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addtoChart() {
        click(addToCartButtonLocator);
    }
}
