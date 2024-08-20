package ru.netology.order;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {

    @Test
    public void validData(){
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").setValue("Кирсанов Андрей");
        $("[data-test-id='phone'] input").setValue("+79520000000");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
