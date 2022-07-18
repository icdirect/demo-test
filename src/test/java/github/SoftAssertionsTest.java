package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @Test

    void shouldFindJunitCode() {

        //открываем страницу с selenide
        open("https://github.com/selenide/selenide");
        //открываем вики
        $("#wiki-tab").click();
        //разворачиваем правый блок
        $("ul li.wiki-more-pages-link").$("button").click();
        //кликаем по softAssertions
        $(byText("SoftAssertions")).click();
        //проверяем что на страницу присутствует код для junit5
        $(".markdown-body").shouldHave(Condition.text("com.codeborne.selenide.junit5.SoftAssertsExtension"));

    }
}
