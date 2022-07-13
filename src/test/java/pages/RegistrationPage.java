package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable =  $(".table-responsive"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            chooseButton = $("#uploadPicture"),
            addressInput =  $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            filledFormModal = $(".modal-header"),
            birthDatePicker = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput");

    //actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage setMobile(String mobileNumber) {
        numberInput.setValue(mobileNumber);

        return this;
    }

    public RegistrationPage setBirthDate (String day, String month, String year ){
        birthDatePicker.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hubbyOne, String hobbyTwo) {
        $(byText(hubbyOne)).click();
        $(byText(hobbyTwo)).click();

        return this;
    }

    public RegistrationPage setPicture(String picName) {
        chooseButton.uploadFromClasspath(picName);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        addressInput.setValue(currentAddress);

        return this;
    }


    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter().pressEnter();

        return this;
    }

    public RegistrationPage verifyForm(String formtext) {
        filledFormModal.shouldHave(text(formtext));

        return this;
    }

    //checks
    public RegistrationPage checkForm (String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}
