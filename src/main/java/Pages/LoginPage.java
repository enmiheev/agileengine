package Pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {

    public LoginPage go() {
        open("https://www.facebook.com/");
        return this;
    }

    public LoginPage enterEmail(String email) {
        $(byAttribute("data-testid","royal_email"))
                .setValue(email);
        return this;
    }

    public LoginPage enterPassword(String pwd) {
        $(byAttribute("data-testid","royal_pass"))
                .setValue(pwd);
        return this;
    }

    public HomePage clickLogIn() {
        $(byAttribute("data-testid","royal_login_button"))
                .click();
        return page(HomePage.class);
    }
}
