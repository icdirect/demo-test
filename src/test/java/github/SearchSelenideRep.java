package github;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.AllureResultsWriter;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;


public class SearchSelenideRep {

    @Test

    void shouldFindSelenideInGithub() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        //открыть страницу github.com
        open("https://github.com/");
        //ввести в поле поиска selenide и нажать enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide/selenide"));

    }

}
//ARRANGE
//ACT
//ASSERT
