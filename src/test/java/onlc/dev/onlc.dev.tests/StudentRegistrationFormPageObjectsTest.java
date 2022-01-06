package onlc.dev.onlc.dev.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import onlc.dev.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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
        registrationPage.typeCheckboxSports()
                .typeCheckboxSubjects()
                .typeUploadPicture()
                .typeCurrentAddress(streetAddress)
                .typeScroll()
                .typeStateCity()
                .typeClick()
                .typeCity()
                .typeSubmit()
                .typeModal()
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Other")
                .checkResultsValue("Mobile", "7733333333")
                .checkResultsValue("Date of Birth", "30 July,2008")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Sports")
                .checkResultsValue("Picture", "1.jpg")
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", "Haryana Panipat");

    }

}
