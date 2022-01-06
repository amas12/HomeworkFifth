package onlc.dev.onlc.dev.tests;



import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.codeborne.selenide.selector.WithText;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byText;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


        public class StudentRegistrationForm {

        @BeforeAll
        static void setUp() {
            Configuration.baseUrl = "https://demoqa.com/";
            //Configuration.browser = "1920x1080";
        }

        @Test
        void fillFormTest() throws InterruptedException {
            Faker faker = new Faker();
            open("automation-practice-form");
            $("#firstName").setValue("George"); //(faker.name().fullName());
            $("#lastName").setValue("Clooney");
            $("#userEmail").setValue("test@tets.test");
            $(".custom-control").click();
            $("#userNumber").setValue("7674635847");
            $("#dateOfBirthInput").click();
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("April");
            $(".react-datepicker__year-select").selectOption("1999");
            $(".react-datepicker__day--012").click();
            $("#hobbiesWrapper").click();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#uploadPicture").uploadFromClasspath("img/1.jpg");
            //$("#uploadPicture").uploadFile(new File("fixtures/EIEXH0aWkAMsRvR.jpg"));
            $("#currentAddress").setValue("USA");
            $("#state").scrollTo().click();
            //$(new WithText("Haryana")).shouldHave(text("H)"aryana")).click();
            $(byText("Haryana")).shouldBe(visible).click();
            $("#city").click();
            $(new WithText("Panipat")).shouldHave(text("Panipat")).click();
            $("#submit").click();
            $(".modal-content");
            $(new WithText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
            assertEquals("Haryana Panipat","Haryana Panipat");
            /*$(".table-responsive").shouldHave(text("George Clooney"),text("test@tets.test"),
                text("Male"),text("7674635847"),text("12 April,1999"),
               text("English"),text("Reading"),text("1.jpg"),text("USA"),text("Haryana Panipat"));первый варик*/
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("George Clooney"));//второй варик
            $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@tets.test"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7674635847"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("12 April,1999"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.jpg"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("USA"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));

        }


    }

