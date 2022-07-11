package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest {

    @BeforeAll
    static void beforeall() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2560x1600";
    }

    @Test
    void successFillTest() {
         open("/text-box");
         $(".main-header").shouldHave(text("Text Box"));
         $("#userName").setValue("Tom");
         $("#userEmail").setValue("Tom@mail.ru");
         $("#currentAddress").setValue("Main street 1");
         $("#permanentAddress").setValue("Main street 2");
         $("#submit").click();
         $("#output").shouldHave(text("Tom"), text("Tom@mail.ru"), text("Main street 1"), text("Main street 2"));



    }
}
