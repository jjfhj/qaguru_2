package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        //Заполнение полей First Name и Last Name
        $("#firstName").setValue("Carol");
        $("#lastName").setValue("Delmonte");

        //Заполнение поля Email
        $("#userEmail").setValue("CarolBDelmonte@armyspy.com");

        //Выбор пола в поле Gender
        $("[for=\"gender-radio-1\"]").click();

        //Заполнение поля Mobile
        $("#userNumber").setValue("8165059611");

        //Выбор даты рождения в поле Date of Birth
        $("#dateOfBirthInput").click();
        $("[class=\"react-datepicker__year-select\"]").$("[value=\"1988\"]").click();
        $("[class=\"react-datepicker__month-select\"]").$("[value=\"7\"]").click();
        $("[class=\"react-datepicker__day react-datepicker__day--016\"]").click();

        //Заполнение поля Subjects
        $("#subjectsInput").setValue("Hindi").pressEnter();

        //Выбор хобби в поле Hobbies
        $("[for=\"hobbies-checkbox-2\"]").click();
        $("[for=\"hobbies-checkbox-3\"]").click();

        //Загрузка изображения
        $("#uploadPicture").uploadFile(new File("src/test/resources/Duck_on_Yeadon_Tarn.jpg"));

        //Заполнение поля Current Address
        $("#currentAddress").setValue("4959 Tree Frog Lane\n" + "Kansas City, MO 64151");

        //Заполнение полей State и City
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        //Нажатие кнопки Submit
        $("#submit").click();

        //Проверка всплывающего модального окна после успешной отправки формы
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("[class=\"table table-dark table-striped table-bordered table-hover\"]").$("tbody")
                .shouldHave(text("Carol Delmonte"),
                        text("CarolBDelmonte@armyspy.com"),
                        text("Male"),
                        text("8165059611"),
                        text("16 August,1988"),
                        text("Hindi"),
                        text("Reading, Music"),
                        text("Duck_on_Yeadon_Tarn.jpg"),
                        text("4959 Tree Frog Lane\n" + "Kansas City, MO 64151"),
                        text("Haryana Panipat"));

    }
}
