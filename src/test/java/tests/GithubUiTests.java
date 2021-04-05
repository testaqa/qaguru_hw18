package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DriverHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GithubUiTests {

    String issueTitle = "Test Issue Title Here";
    String issueBody = "Some issue description";

    @BeforeAll
    public static void beforeAll() {
        DriverHelper.configureDriver();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    @Tag("web")
    void GithubIssueUiTest() {
        open("/testaqa/qaguru_hw18/issues/");

        $("div[aria-label='Issues']").$(linkText(issueTitle)).click();

        $(".comment-body p").should(have(text(issueBody)));
    }

}