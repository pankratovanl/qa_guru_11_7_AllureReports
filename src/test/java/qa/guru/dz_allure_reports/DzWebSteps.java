package qa.guru.dz_allure_reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DzWebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Открыть репозиторий {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Проверить, что существует Issues")
    public void shouldSeeIssue() {
        $(By.partialLinkText("Issues")).should(Condition.exist);
    }

@Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public void takeScreenshot() {
    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
}

}
