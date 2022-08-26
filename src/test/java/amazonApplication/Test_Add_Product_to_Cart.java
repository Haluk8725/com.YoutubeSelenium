package amazonApplication;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;

public class Test_Add_Product_to_Cart extends Parent  {
    Homepage homePage=new Homepage(driver);;
    ProductsPage productPage= new ProductsPage(driver);
    ProductDetailPage productDetailPage= new ProductDetailPage(driver);
    CartPage cartPage= new CartPage(driver);


    @Test
    @Order(1)
    public void searchProduct()  {

        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productPage.isOnProductPage(), "Not on product page");
    }

    @Test
    @Order(2)
    public void selectProduct() {

        productPage.chooseItem(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page");
    }

    @Test
    @Order(3)
    public void addProduct() {
        productDetailPage.addtoChart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Product count is not increase");
    }

    @Test
    @Order(4)
    public void goToChart() {

        homePage.gotoChart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Product was not added to cart");
    }


}
