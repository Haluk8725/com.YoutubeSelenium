package amazonApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Main {
    By productCountLocator= By.cssSelector("span.a-dropdown-prompt");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean checkIfProductAdded() {
        return getCartCount() >0;

    }
    private int getCartCount(){
        String count=find(productCountLocator).getText();
        return Integer.parseInt(count);
    }
}
