package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LabelTestHwLambda {

    @Test
    @Owner("username")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Фича 123")
    @Story("Сторя про лейбл")
    @DisplayName("Проверка наличия лейбла во вкладке Issue")
    @Description("Тест проверяет наличие лейбла на табе Issue")
    @Link(value = "Testlink", url = "https://github.com/selenide/selenide/issues")
    public void labelTest () {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем в поиске Selenide", () -> {
            $("[name=q]").setValue("selenide").pressEnter();
        });

        step("Переходим в репозиторий Selenide", () -> {
            $$("ul.repo-list li").first().$("a").click();
        });

        step("Переходим в Issue tab", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Labels tab", () -> {
            $(".subnav-links").shouldHave(Condition.text("Labels"));
        });


    }


}
