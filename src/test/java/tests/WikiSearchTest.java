package tests;

import config.DeviceHost;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static config.Project.deviceHost;
import static io.qameta.allure.Allure.step;


public class
WikiSearchTest extends TestBase {

    @Test
    @Disabled
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        if(!deviceHost().equals(DeviceHost.BROWSER_STACK)){
            back();
        }

        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}