package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;


public class SearchSelenideRep {

    @Test

    void shouldFindSelenideInGithub() {
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
