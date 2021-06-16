package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class WikipediaSteps {

    @Step("Click 'Continue'")
    public WikipediaSteps clickContinue(){
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        return this;
    }

    @Step("Check page title")
    public WikipediaSteps checkTitlePage(String title){
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text(title));
        return this;
    }

    @Step("Click 'Get Started'")
    public WikipediaSteps clickGetStarted(){
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        return this;
    }

    @Step("Field 'Search Wikipedia' should appear")
    public WikipediaSteps searchFieldShouldAppear() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).should(Condition.appear);
        return this;
    }

}
