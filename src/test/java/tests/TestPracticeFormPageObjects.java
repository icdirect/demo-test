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

        String firstName = "Tom";
        String lastName = "Sawyer";
        String email = "toms@gmail.com";
        String mobile = "9202139991";
        String gender = "Male";
        String month = "November";
        String day = "11";
        String year = "1989";
        String subject = "Maths";
        String hobbyOne = "Sports";
        String hobbyTwo = "Music";
        String picName = "pic.png";
        String address = "Main street 1";
        String state = "NCR";
        String city = "Delhi";
        String verifyText = "Thanks for submitting the form";

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbyOne, hobbyTwo)
                .setPicture(picName)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .verifyForm(verifyText);

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
