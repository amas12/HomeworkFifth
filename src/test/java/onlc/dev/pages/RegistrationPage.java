package onlc.dev.pages;

import com.codeborne.selenide.SelenideElement;
import onlc.dev.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            checkboxGender = $(byText("Other")),
            resultsTable = $(".table-responsive"),
            userEmailInput = $("#userEmail"),
            checkboxSports = $(byText("Sports")),
            checkboxSubjects = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            scroll = $("#state"),
            stateCity = $(byText("Haryana")),
            click = $("#city"),
            city = $("#stateCity-wrapper"),
            submit = $("#submit"),
            modal = $("#example-modal-sizes-title-lg");


    public CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage genderCheck() {
        checkboxGender.click();
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage userNumber() {
        $("#userNumber").setValue("7733333333");
        return this;
    }


    public RegistrationPage typeCheckboxSports() {
        checkboxSports.click();
        return this;
    }

    public RegistrationPage typeCheckboxSubjects() {
        checkboxSubjects.setValue("English").pressEnter();
        return this;
    }

    public RegistrationPage typeUploadPicture() {
        uploadPicture.uploadFromClasspath("img/1.jpg");
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage typeScroll() {
        scroll.scrollTo().click();
        return this;
    }

    public RegistrationPage typeStateCity() {
        stateCity.shouldBe(visible).click();
        return this;
    }

    public RegistrationPage typeClick() {
        click.click();
        return this;
    }

    public RegistrationPage typeCity() {
        city.$(byText("Panipat")).click();
        return this;
    }

    public RegistrationPage typeSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage typeModal() {
        modal.shouldHave(text("Thanks for submitting the form"));
        return this;
    }


    public RegistrationPage checkResultsValue(String key, String value) {

        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;

    }
}
