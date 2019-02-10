package Pages.Components;

import Pages.HomePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class EditPostPopUpComponent {

    public EditPostPopUpComponent enterPostText(String text) {
        SelenideElement postField = $(byAttribute("data-testid","status-attachment-mentions-input"));
        postField.waitUntil(appear, 5000);
        postField.clear();
        postField.setValue(text);
        return this;
    }

    public HomePage clickSaveBtn() {
        SelenideElement saveBtn = $(byAttribute("data-testid","react-composer-post-button"));
        saveBtn.click();
        saveBtn.waitUntil(disappear, 2000);
        return page(HomePage.class);
    }
}
