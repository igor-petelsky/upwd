package pages.products;

import base.BaseStep;
import enums.ProductNames;
import enums.ProductSortOptions;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductsPageSteps extends BaseStep {

    private final ProductsPage productsPage;

    public ProductsPageSteps() {
        productsPage = new ProductsPage();
    }

    @Step
    public void checkProductItemNameVisible() {
        checkElementsHaveVisibleElement(productsPage.productNames);
    }

    @Step
    public ProductsPageSteps sortProductsByOption(ProductSortOptions sortOption) {
        clickElement(productsPage.sortContainer);
        productsPage.sortContainer.selectOptionByValue(sortOption.getValue());

        return this;
    }

    @Step
    public ProductsPageSteps checkProductsSortedByPriceLowToHigh() {
        List<Double> prices = new ArrayList<>();
        List<String> priceTexts = productsPage.productPrices.texts();

        for (String price : priceTexts) {
            prices.add(Double.parseDouble(price.replace("$", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Comparator.naturalOrder());

        if (!prices.equals(sortedPrices)) {
            System.out.println("Actual prices: " + prices);
            System.out.println("Expected prices: " + sortedPrices);

            throw new AssertionError("Products are not sorted by price low to high");
        }

        return this;
    }

    @Step
    public ProductsPageSteps addProductToCartByName(ProductNames productName) {
        clickElement(productsPage.getAddToCartButtonByProductName(productName.getName()));

        return this;
    }

    @Step
    public void clickCart() {
        clickElement(productsPage.cart);
    }
}
