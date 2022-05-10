package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.*;

public class LabelsTest {
    @Test
    @Owner("pankratovanl")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Создание новой задачи")
    @DisplayName("Проверка создания Issue для авторизованного пользователя")
    @Description("Этот тест проверяет создание Issue, когда происходит....")
    @Link(value = "Testing", url = "https://github.com")

    public void testAnnotatedLabels() {

    }

    @Test
    public void TestDynamicLabels(){
        label("owner", "pankratovanl");
        label("severity", SeverityLevel.CRITICAL.value());
        feature("Задачи в репозитории");
        story("Удаление новой задачи");
        getLifecycle().updateFixture(testCase -> {
            testCase.setName("Проверка удаления Issue для авторизованного пользователя");
        });
        description("Этот тест проверяет удаление Issue, когда происходит....");
        link("Testing", "https://github.com");
    }

    @Test
    public void testParameters(){
        parameter("Регион", "Московская область");
        parameter("Город", "Москва");
    }
}
