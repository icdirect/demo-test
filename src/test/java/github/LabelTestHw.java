package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class LabelTestHw {

    @Test
    public void labelTest () {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab").click();
        $(".subnav-links").shouldHave(Condition.text("Labels"));

    }
}
