package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1020";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void gitHubTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit4 just describe rule inside test class:"));
    }
}
