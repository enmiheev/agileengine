package Pages.Components;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NewPostPopUpComponent {

    public NewPostPopUpComponent enterPostText(String text) {
        $(byAttribute("data-testid","status-attachment-mentions-input")).
                setValue(text);
        return this;
    }

    public NewsFeedComponent clickPostBtn() {
        $(byAttribute("data-testid","react-composer-post-button"))
                .click();
        return page(NewsFeedComponent.class);
    }
}
