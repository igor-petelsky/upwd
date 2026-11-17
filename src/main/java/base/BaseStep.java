package base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static java.lang.String.format;

public class BaseStep {

    protected void clickElement(SelenideElement element) {
        element.shouldBe(visible.because("Element isn't visible"))
                .click();
    }

    protected void setValueIntoInputField(SelenideElement inputField, String value) {
        inputField.shouldBe(visible.because("Input field isn't visible"))
                .setValue(value);
    }

    protected void checkTextEquals(SelenideElement element, String expectedText) {
        element.shouldHave(
                exactText(expectedText).because(
                        format("Expected element text to be [%s]", expectedText)
                )
        );
    }

    protected void checkElementsHaveVisibleElement(ElementsCollection elements) {
        elements.filter(visible)
                .shouldHave(
                        sizeGreaterThan(0).because("No visible elements found")
                );
    }

    protected void checkIfVisible(SelenideElement element) {
        element.shouldBe(visible.because("Element isn't visible"));
    }
}
