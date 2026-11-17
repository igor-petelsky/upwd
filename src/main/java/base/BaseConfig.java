package base;

import com.codeborne.selenide.Configuration;

public class BaseConfig {

    public static void setup() {
        Configuration.browser = "chrome";

        boolean remote = Boolean.getBoolean("remote");

        if (remote) {
            Configuration.remote = "http://selenium:4444";
        }
    }
}