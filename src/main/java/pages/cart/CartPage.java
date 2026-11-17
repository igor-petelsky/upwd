package pages.cart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    SelenideElement getCartItemByName(String itemName) {
        return $x(String.format(
                "//*[contains(@class, 'inventory_item_name') and text()='%s']",
                itemName
        ));
    }
}
