package amazonApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends Main{
    SearchBox searchBox;
    By cartCountLocator=By.id("nav-cart-count");
    public Homepage(WebDriver driver) {
        super(driver);
        searchBox=new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount()>0;

    }

    public void gotoChart() {
        click(cartCountLocator);
    }
    private int getCartCount(){
        String count=find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
}
