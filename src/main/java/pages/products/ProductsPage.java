package pages.products;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ProductsPage {

    SelenideElement sortContainer = $x("//select[@data-test='product-sort-container']");
    SelenideElement cart = $("[data-test=shopping-cart-link]");

    ElementsCollection productNames = $$("[data-test=inventory-item-name]");
    ElementsCollection productPrices = $$("[data-test=inventory-item-price]");

    SelenideElement getAddToCartButtonByProductName(String productName) {
        return $x(format("//*[@class='inventory_item_name ' and text()='%s']" +
                "/ancestor::div[@class='inventory_item']//button[contains(@id, 'add-to-cart')]", productName));
    }
}
