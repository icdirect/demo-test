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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testform() {

        registrationPage
                .openPage()
                .setFirstName("Tom")
                .setLastName("Sawyer")
                .setEmail("toms@gmail.com")
                .setGender()
                .setMobile("9202139991")
                .setBirthDate("11", "November", "1989")
                .setSubjects()
                .setHobbies()
                .setPicture("pic.png")
                .setCurrentAddress("Main street 1")
                .setState("NCR")
                .setCity("Delhi")
                .verifyForm("Thanks for submitting the form");

        registrationPage
                .checkForm("Student Name", "Tom Sawyer")
                .checkForm("Student Email", "toms@gmail.com")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "9202139991")
                .checkForm("Date of Birth", "11 November,1989")
                .checkForm("Subjects", "Maths")
                .checkForm("Hobbies", "Sports, Music")
                .checkForm("Picture", "pic.png")
                .checkForm("Address", "Main street 1")
                .checkForm("State and City", "NCR Delhi");

    }
}
