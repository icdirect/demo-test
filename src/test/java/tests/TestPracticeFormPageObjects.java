 package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestPracticeFormPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void openbrowser() {
        Selenide.open("https://demoqa.com/");
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testform() {

        registrationPage.openPage()
                .setFirstName("Tom")
                .setLastName("Sawyer");

        $("#userEmail").setValue("toms@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9202139991");
        registrationPage.setBirthDate("11", "November", "1989");


        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        File cv = new File("src/test/resources/pic.png");
        $("#uploadPicture").uploadFile(cv);
        $("#currentAddress").setValue("Main street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        registrationPage
                .checkForm("Student Name", "Tom Sawyer")
                .checkForm("Email", "toms@gmail.com")
                .checkForm("Gender", "Male");

        $(".table-responsive").shouldHave(text("9202139991"));
        $(".table-responsive").shouldHave(text("11 November,1989"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("pic.png"));
        $(".table-responsive").shouldHave(text("Main street 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}
