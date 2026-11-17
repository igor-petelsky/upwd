package common;

import base.BaseStep;
import io.qameta.allure.Step;

public class CommonSteps extends BaseStep {

    private final CommonElements commonElements;

    public CommonSteps() {
        commonElements = new CommonElements();
    }

    @Step
    public void checkPageTitle(String expectedTitle) {
        checkTextEquals(commonElements.pageTitle, expectedTitle);
    }
}
