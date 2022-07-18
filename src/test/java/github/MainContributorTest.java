package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class MainContributorTest {

    @Test
    void andrewMainContributor() {
        //открыть страницу репозитория
        open("https://github.com/selenide/selenide");
        //подвести мышку в первому элементу в области Contribution
        $(".Layout-sidebar").$(withText("Contributors"))
                .closest(".BorderGrid-row").$("ul li").hover();
        //check: в появившемся окне (overlay) текст Andrei Solntsev
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
