package onlc.dev.onlc.dev.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.codeborne.selenide.selector.WithText;
import com.github.javafaker.Faker;
import onlc.dev.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static onlc.dev.onlc.dev.tests.TestData.userEmail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistrationFormPageObjectsTest {
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String streetAddress = faker.address().streetAddress();
    String userEmail = faker.internet().emailAddress();



    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/";
        //Configuration.browser = "1920x1080";
    }

    @Test
    void fillFormTest() throws InterruptedException {


        registrationPage.openPage()
        .typeFirstName(firstName)
        .typeLastName(lastName)
        .typeUserEmail(userEmail)
        .genderCheck()
        .userNumber()
        .calendarComponent.setDate();
        $("#hobbiesWrapper").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");
        //$("#uploadPicture").uploadFile(new File("fixtures/EIEXH0aWkAMsRvR.jpg"));
        $("#currentAddress").setValue(streetAddress);
        $("#state").scrollTo().click();
        //$(new WithText("Haryana")).shouldHave(text("H)"aryana")).click();
        $(byText("Haryana")).shouldBe(visible).click();
        $("#city").click();
        $(new WithText("Panipat")).shouldHave(text("Panipat")).click();
        $("#submit").click();
        $(".modal-content");
        $(new WithText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
        assertEquals("Haryana Panipat", "Haryana Panipat");
            /*$(".table-responsive").shouldHave(text("George Clooney"),text("test@tets.test"),
                text("Male"),text("7674635847"),text("12 April,1999"),
               text("English"),text("Reading"),text("1.jpg"),text("USA"),text("Haryana Panipat"));первый варик*/
        registrationPage.checkResultsValue("Student Name", firstName + " " +lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Other")
                .checkResultsValue("Mobile", "7733333333")
                .checkResultsValue("Date of Birth", "30 July,2008")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "1.jpg")
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", "Haryana Panipat");

    }

}
