package Pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class NewPostPopUpComponent {
    private SelenideElement postField = $(byAttribute("data-testid","status-attachment-mentions-input"));
    private SelenideElement postBtn = $(byAttribute("data-testid","react-composer-post-button"));

    public void enterPostText(String text) {
        postField.setValue(text);
    }

    public void clickPostBtn() {
        postBtn.click();
    }
}
