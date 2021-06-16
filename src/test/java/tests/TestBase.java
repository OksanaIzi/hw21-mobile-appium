package tests;

import com.codeborne.selenide.Configuration;
import config.DeviceHost;
import config.Project;
import driver.LocalMobileDriver;
import helpers.Attach;
import helpers.Browserstack;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class TestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");


        if (!Project.deviceHost().equals(DeviceHost.LOCAL)) {
            String sessionId = getSessionId();
            Attach.attachVideo(sessionId);
            if (Project.deviceHost().equals(DeviceHost.BROWSER_STACK))
                Attach.attachAsText("Browserstack build link",
                        Browserstack.getBSPublicLink(sessionId));
        }

        closeWebDriver();
    }
}




