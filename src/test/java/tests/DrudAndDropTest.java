package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DrudAndDropTest {

    @Test

    void drugAndDrop() {
        //открываем страничку с функционалом
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //перемещаем квадраты
        $("#column-a").dragAndDropTo($("#column-b"));
        //проверяем, что квадраты переместились
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
