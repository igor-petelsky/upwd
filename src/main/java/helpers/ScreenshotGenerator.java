package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotGenerator {

    public static void captureScreenshot() {

        String file = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime()) + ".png";

        System.out.println("::: Got an exception ::: Will save screenshot into file:" + file);

        byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        try {
            String screenshotPath = "build/reports/tests/";
            FileUtils.writeByteArrayToFile(new File(screenshotPath + file), saveScreenshot(screenshot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "URL: ", type = "text/plain")
    public static String attachUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
