package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DataHelper.*;
import static io.qameta.allure.Allure.step;

public class QaGuruTest extends TestBase {

    @Test
    @DisplayName("Successful registration")
    public void successfulRegistration() {
        String email = getRandomEmailAddress();
        String firstAndLastName = getRandomFirstAndLastName();

        step("Open login page", () -> {
            open("https://qa.guru/cms/system/login");
        });
        step("Open registration page", () -> {
            $(".btn-register").click();
        });
        step("Input login and password", () -> {
            $(".active-state").$(byName("email")).val(email);
            $(".active-state").$(byName("full_name")).val(firstAndLastName).pressEnter();
        });
        step("Verify authorized zone", () -> {
            $(".login").click();
            $(".btn-logout").shouldBe(visible)
                    .shouldHave(text("Сменить пользователя"));
        });
    }

}

