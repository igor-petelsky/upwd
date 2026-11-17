package ui;

import base.BaseTest;
import enums.PageTitles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.main.MainPageSteps;
import pages.products.ProductsPageSteps;
import test_data.TestUsers;

public class AuthTests extends BaseTest {

    private MainPageSteps mainPageSteps;
    private ProductsPageSteps productsPageSteps;

    @BeforeClass
    public void setUpTests() {
        mainPageSteps = new MainPageSteps();
        productsPageSteps = new ProductsPageSteps();
    }

    @Test
    public void signInTest() {
        mainPageSteps.signIn(TestUsers.STANDARD_USER, TestUsers.PASSWORD);
        commonSteps.checkPageTitle(PageTitles.PRODUCTS.getTitle());
        productsPageSteps.checkProductItemNameVisible();
    }
}
