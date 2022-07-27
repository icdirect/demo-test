package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.*;

public class WebStepsForLabel {

    @Step("Открываем главную страницу")
    public void openpage (){
        open("https://github.com/");
    }

    @Step("Ищем в поиске Selenide")
    public void searchSelenide () {
        $("[name=q]").setValue("selenide").pressEnter();
    }

    @Step("Переходим в репозиторий Selenide")
    public void selenideRepo () {
        $$("ul.repo-list li").first().$("a").click();
    }

    @Step("ереходим в Issue tab")
    public void openIssueTab () {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Labels tab")
    public void labelsAssert () {
        $(".subnav-links").shouldHave(Condition.text("Labels"));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
