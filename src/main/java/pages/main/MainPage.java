package pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    SelenideElement userNameField =  $("[data-test=username]");
    SelenideElement passwordField =  $("[data-test=password]");
    SelenideElement loginButton =  $("[data-test=login-button]");
}
