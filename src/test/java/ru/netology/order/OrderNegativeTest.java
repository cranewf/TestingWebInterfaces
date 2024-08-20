package ru.netology.order;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderNegativeTest {
    @Test
    public void emptyName(){
        open("http://localhost:9999/");
        $("[data-test-id='phone'] input").setValue("+79520000000");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void emptyPhone(){
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").setValue("Кирсанов Андрей");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void invalidName(){
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").setValue("Kirsanov Andrei");
        $("[data-test-id='phone'] input").setValue("+79520000000");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void invalidPhone(){
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").setValue("Кирсанов Андрей");
        $("[data-test-id='phone'] input").setValue("79520000000");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void checkboxNotChecked(){
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").setValue("Кирсанов Андрей");
        $("[data-test-id='phone'] input").setValue("+79520000000");
        $("button.button").click();
        $("[data-test-id='agreement'].input_invalid").shouldBe(visible);
    }
}
