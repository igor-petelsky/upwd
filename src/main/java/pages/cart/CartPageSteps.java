package pages.cart;

import base.BaseStep;
import enums.ProductNames;
import io.qameta.allure.Step;

public class CartPageSteps extends BaseStep {

    private final CartPage cartPage;

    public CartPageSteps() {
        cartPage = new CartPage();
    }

    @Step
    public void checkProductItemPresentByName(ProductNames productName) {
        checkIfVisible(cartPage.getCartItemByName(productName.getName()));
    }
}
