package Pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class EditPostPopUpComponent {
    private SelenideElement postField = $(byAttribute("data-testid","status-attachment-mentions-input"));
    private SelenideElement saveBtn = $(byAttribute("data-testid","react-composer-post-button"));

    public void enterPostText(String text) {
        postField.waitUntil(appear, 5000);
        postField.clear();
        postField.setValue(text);
    }

    public void clickSaveBtn() {
        saveBtn.click();
        saveBtn.waitUntil(disappear, 2000);
    }
}
