package jjfhj.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        $("#currentAddress").setValue("4959 Tree Frog Lane\n" +
                "Kansas City, MO 64151");

        //Заполнение полей State и City
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        //Нажатие кнопки Submit
        $("#submit").click();

        //Проверка всплывающего модального окна после успешной отправки формы
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//tbody/tr[1]/td[2]").shouldHave(text("Carol Delmonte"));
        $x("//tbody/tr[2]/td[2]").shouldHave(text("CarolBDelmonte@armyspy.com"));
        $x("//tbody/tr[3]/td[2]").shouldHave(text("Male"));
        $x("//tbody/tr[4]/td[2]").shouldHave(text("8165059611"));
        $x("//tbody/tr[5]/td[2]").shouldHave(text("16 August,1988"));
        $x("//tbody/tr[6]/td[2]").shouldHave(text("Hindi"));
        $x("//tbody/tr[7]/td[2]").shouldHave(text("Reading, Music"));
        $x("//tbody/tr[8]/td[2]").shouldHave(text("Duck_on_Yeadon_Tarn.jpg"));
        $x("//tbody/tr[9]/td[2]").shouldHave(text("4959 Tree Frog Lane\n" +
                "Kansas City, MO 64151"));
        $x("//tbody/tr[10]/td[2]").shouldHave(text("Haryana Panipat"));
    }
}