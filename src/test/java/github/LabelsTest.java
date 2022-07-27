package github;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("Name")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Создание задачи")
    @DisplayName("Проверка создания Issue для автиоризованного пользователя")
    @Description("Этот тест проверяет бла бла бла......")
    @Link(value = "Testing", url = "https://github.com")
    public void testAnnotatedLabels () {

    }

    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Удаление новой задачи");
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Проверка удаление Issue для авторизованного пользователя");
        });
        Allure.description("Этот тест проверят создание Issue когда происходит....");
        Allure.link("Testing", "https://github.com");
    }

    @Test
    public void testParameters() {
        Allure.parameter("Регион", "Московская область");
        Allure.parameter("Город", "Москва");
    }
}
