package ui;

import base.BaseTest;
import enums.ProductNames;
import enums.ProductSortOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.cart.CartPageSteps;
import pages.main.MainPageSteps;
import pages.products.ProductsPageSteps;
import test_data.TestUsers;

public class ProductTests extends BaseTest {

    private MainPageSteps mainPageSteps;
    private ProductsPageSteps productsPageSteps;
    private CartPageSteps cartPageSteps;

    @BeforeClass
    public void setUpTests() {
        mainPageSteps = new MainPageSteps();
        productsPageSteps = new ProductsPageSteps();
        cartPageSteps = new CartPageSteps();
    }

    @BeforeMethod
    public void beforeMethod() {
        mainPageSteps.signIn(TestUsers.STANDARD_USER, TestUsers.PASSWORD);
    }

    @Test
    public void productsPriceSortingAndAddToCartTest() {
        productsPageSteps
                .sortProductsByOption(ProductSortOptions.PRICE_LOW_TO_HIGH)
                .checkProductsSortedByPriceLowToHigh()
                .addProductToCartByName(ProductNames.SAUCE_LABS_BIKE_LIGHT)
                        .clickCart();
        cartPageSteps.checkProductItemPresentByName(ProductNames.SAUCE_LABS_BIKE_LIGHT);
    }
}
