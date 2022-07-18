package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {
    void browser_comand_examples() {
        open("https://www.google.com/");
        open("/documentation.html");
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("user", "Password"));

        //кнопки назад и рефреш
        Selenide.back();
        Selenide.refresh();

        //очистка куки и локал сторэдж
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        //команды для алертов
        Selenide.confirm();
        Selenide.dismiss();

        Selenide.closeWindow(); //закрыть активное окно
        Selenide.closeWebDriver(); // закрыть браузер целиком

        Selenide.switchTo().frame("name"); //переход во фрейм
        Selenide.switchTo().defaultContent(); //вернуться из фрейма

        Selenide.switchTo().window("the internet"); //перейти в новое окно
    }

    void selector_examples() {

        //доллар и элемент одно и тоже - алиасы, можно использовать и тот и другой
        $("div").click();
        element("div").click();

        $("div", 2).click(); //ищет элемент по счету

        $x("//h1/div").click(); //xPath
        $(byXpath("//h1/div")).click(); //xPath

        $(byText("text")); // ищет эелемент по тексту
        $(withText("text)")); //ищет вхождение элемента по тексту

        $("").parent();
        $("").sibling(1); //на индекс элементов вниз
        $("").preceding(1); //на индекс элементов вверх
        $("").closest("div"); //ближайший элемент вверх
        $("").ancestor("div"); //ближайший элемент вверх
    }

    void action_examples(){
        $("").click();
        $("").doubleClick();
        $("").contextClick(); //клик правой кнопкой

        $("").hover(); //наведение мышки

        $("").setValue("text"); //очищает поле поиска и пишет туда текст
        $("").append("text"); // добавит текст к уже существующему
        $("").clear(); //очищает поле
        $("").setValue(""); //тоже очищает поле, может сработать правильнее clear

        $("div").sendKeys("c"); //нажатие элемента кнопкой
        actions().sendKeys("c").perform(); //нажать на кнопку во всем приложении (в жира например создает новый тикет)
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")); //нажать комбинацию клавиш
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); // тоже самое только на все хтмл

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        actions().moveToElement($("div"))
                .clickAndHold().moveByOffset(300, 200).release().perform(); //драг-н-дроп

    }

    void assertion_examples() {
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("text"));
        $("").shouldNotHave(text("text"));
        $("").should(appear);
        $("").shouldNot(appear);

        $("").shouldBe(visible, Duration.ofSeconds(30)); //кастомный таймаут

    }

    void condition_examples(){
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("text"));
        $("").shouldHave(exactText("text")); //точный текст
        $("").shouldHave(textCaseSensitive("aBc")); //регистрозависимый
        $("").shouldHave(exactTextCaseSensitive("aBc")); //точный регистрозависимый
        $("").should(matchText("[8-9]abc$"));

        $("").shouldHave(cssClass("red")); //есть ли в элементе класс который мы указали
        $("").shouldHave(cssValue("font-size", "12")); //проверяет физические свойства элемента

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldBe(checked);//для чекбоксов

        $("").should(exist); // проверяет наличие элемента в доме и не важно видимый он или нет

        $("").shouldBe(disabled); //проверяет элемент (чекбокс) доступен или нет
        $("").shouldBe(enabled);

    }

    void collection_examples(){

        $$("div").filterBy(text("123")).shouldHave(size(12)); //фильтрует все элементы с текстом 123
        $$("div").excludeWith(text("123")).shouldHave(size(1)); //оставляет все эелементы кроме 123

        $$("div").first().click(); //оба кликают по первому элементу
        $("div").click(); //оба кликают по первому элементу

        $$("div").last().click(); //кликает по последнему элементу
        $$("div").get(1).click(); //кликеает по нужному по счету элементу
        $("div", 1).click();//как предыдущее но работает быстрее

        $$("div").findBy(text("123")); //так кже как и FilterBy сразу находит первый элемент

        //asserts
        $$("div").filterBy(text("123")).shouldHave(size(0));
        $$("div").shouldBe(CollectionCondition.empty); //тоже самое, что и первое

        // проверки
        $$("div").shouldHave(texts("text1", "text2")); //проверяет тексты на вхождение
        // и еще проверяет на количество элементов, если будет больше чем задано будет ошибка
        //если они будут в другом порядке, тоже будет ошибка
        $$("div").shouldHave(exactTexts("text1", "text2")); //проверяет точные тексты
        $$("div").shouldHave(textsInAnyOrder("text1", "text2")); //проверяет в любом порядке
        $$("div").shouldHave(exactTextsCaseSensitiveInAnyOrder("text1", "text2")); //разный регистр в любом порядке
        $$("div").shouldHave(itemWithText("text1")); //ищет в коллекции оидн элемент с текстом

        $$("div").shouldHave(sizeGreaterThan(0)); //если размер должен быть больше чем
        $$("div").shouldHave(sizeLessThan(10)); // если размер должен быть меньше чем
        $$("div").shouldHave(sizeGreaterThanOrEqual(0)); // больше или равен
        $$("div").shouldHave(sizeLessThanOrEqual(0)); //меньше или раверн
    }

    void file_operations_examples() throws FileNotFoundException {

        File file1 = $("a.filelink").download(); //только для <a href=".."> линков (скачивание файла по ссылке)
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); //скачивание файлов актуальное

        File file =  new File("src/test/resouces/pic.png"); //загрузка файла и сабмит
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("pic.png");
        $("uploadbutton").click();

    }

    void javascript_examples(){
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);
    }


}


