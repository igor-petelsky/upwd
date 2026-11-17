package pages.main;

import base.BaseStep;
import io.qameta.allure.Step;


public class MainPageSteps extends BaseStep {

    private final MainPage mainPage;

    public MainPageSteps() {
        mainPage = new MainPage();
    }

    @Step
    public void fillUserName(String userName) {
        setValueIntoInputField(mainPage.userNameField, userName);
    }

    @Step
    public void fillPassword(String userName) {
        setValueIntoInputField(mainPage.passwordField, userName);
    }

    @Step
    public void clickLoginButton() {
        clickElement(mainPage.loginButton);
    }

    @Step
    public void signIn(String userName, String password) {
        fillUserName(userName);
        fillPassword(password);
        clickLoginButton();
    }
}
