package ru.netology.testweb;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenidTest {


    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='city'] input").setValue("Москва");
        form.$("[placeholder='Дата встречи']").setValue("20.12.2021");
        form.$("[data-test-id='name'] input").setValue("Каренина-Подпоездом Анна");
        form.$("[data-test-id='phone'] input").setValue("+79220000222");
        form.$("[data-test-id='agreement']").click();
        $$(".button__text").find(exactText("Забронировать")).click();
        System.out.println("1");
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }
}