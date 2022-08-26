package amazonApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends Main  {
    By checkpage=By.id("p_n_free_shipping_eligible-title");
    By productNameLocator=By.cssSelector("span.a-size-base-plus");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(checkpage);
    }

    public void chooseItem(int i)
      {
        getAllProducts().get(i).click();
    }
    private List<WebElement>getAllProducts(){
        return findAll(productNameLocator);
    }
}
