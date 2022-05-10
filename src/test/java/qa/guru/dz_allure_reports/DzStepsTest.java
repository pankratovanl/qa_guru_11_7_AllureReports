package qa.guru.dz_allure_reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class DzStepsTest {

    private static final String REPOSITORY = "pankratovanl/qa_guru_11_7_AllureReports";


    @Test
    public void testLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Открыть репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Проверить, что Issue существует в репозитории", () -> {
            $(By.partialLinkText("Issues")).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DzWebSteps steps = new DzWebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);

        steps.shouldSeeIssue();

        steps.takeScreenshot();

    }
}
