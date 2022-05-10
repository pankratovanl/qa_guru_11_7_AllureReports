package qa.guru.dz_allure_reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DzSelenideTestWithListener {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("pankratovanl/qa_guru_11_7_AllureReports");
        $(".header-search-input").submit();

        $(By.linkText("pankratovanl/qa_guru_11_7_AllureReports")).click();
        $(By.partialLinkText("Issues")).should(Condition.exist);
    }

}
