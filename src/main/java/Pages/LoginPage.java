package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {
    private SelenideElement emailField = $(byAttribute("data-testid","royal_email"));
    private SelenideElement passwordField = $(byAttribute("data-testid","royal_pass"));
    private SelenideElement logInBtn = $(byAttribute("data-testid","royal_login_button"));

    public void Go() {
        open("https://www.facebook.com/");
    }

    public void EnterEmail(String email) {
        emailField.setValue(email);
    }

    public void EnterPassword(String pwd) {
        passwordField.setValue(pwd);
    }

    public void ClickLogIn() {
        logInBtn.click();
    }
}
