package common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CommonElements {

    SelenideElement pageTitle = $("[data-test=title]");
}
