package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {
    private SelenideElement emailField = $(byAttribute("data-testid","royal_email"));
    private SelenideElement passwordField = $(byAttribute("data-testid","royal_pass"));
    private SelenideElement logInBtn = $(byAttribute("data-testid","royal_login_button"));

    public void go() {
        open("https://www.facebook.com/");
    }

    public void enterEmail(String email) {
        emailField.setValue(email);
    }

    public void enterPassword(String pwd) {
        passwordField.setValue(pwd);
    }

    public void clickLogIn() {
        logInBtn.click();
    }
}
